package cn.wuweiblog.computertest.intercepter;

import cn.wuweiblog.computertest.annotation.Token;
import org.aopalliance.intercept.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Jervain on 2016-11-19.
 */
public class DuplicateSubmitInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (o instanceof HandlerMethod) {
            Method method = ((HandlerMethod) o).getMethod();
            if (method.isAnnotationPresent(Token.class)) {
                Token token = method.getAnnotation(Token.class);
                if (token.save()) {
                    httpServletRequest.getSession().setAttribute("token", UUID.randomUUID().toString());
                }
                if (token.remove()) {
                    if (isRepeat(httpServletRequest)) {
                        throw new Exception("不能重复提交");
                    }
                    httpServletRequest.getSession().removeAttribute("token");
                }
            }
            return true;
        }else {
            return super.preHandle(httpServletRequest, httpServletResponse, o);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean isRepeat(HttpServletRequest request) {
        String serverToken = (String) request.getSession().getAttribute("token");
        if (serverToken == null)    return true;
        String clientToken = request.getParameter("token");
        if (clientToken == null)    return true;
        return !serverToken.equals(clientToken);
    }

}
