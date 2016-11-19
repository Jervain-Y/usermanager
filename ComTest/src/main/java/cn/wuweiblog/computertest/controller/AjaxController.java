package cn.wuweiblog.computertest.controller;

import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.common.BeanUtil;
import cn.wuweiblog.computertest.service.AjaxUserService;
import cn.wuweiblog.computertest.service.UserService;
import cn.wuweiblog.computertest.structs.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jervain on 2016-11-18.
 */
@RestController
public class AjaxController {


    @Autowired
    private AjaxUserService service;
    @Autowired
    private UserService userService;


    @RequestMapping("/index/ajax")
    public ResponseMsg ajax(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Integer draw = Integer.valueOf(parameterMap.get("draw")[0]);
        Integer start = Integer.valueOf(parameterMap.get("start")[0]);
        Integer length = Integer.valueOf(parameterMap.get("length")[0]);
        String search = parameterMap.get("search[value]")[0];
        String date = parameterMap.get("date")[0];
        Integer role = Integer.valueOf(parameterMap.get("role")[0]);
        return service.responseMsg(draw, start, length, search, date, role);
    }


    @RequestMapping("/index/status")
    public Integer status(Integer id) {
        return userService.changeStatus(id);
    }


    @RequestMapping("/index/delete")
    public Integer delete(Integer id) {
        return userService.deleteUserById(id);
    }


}
