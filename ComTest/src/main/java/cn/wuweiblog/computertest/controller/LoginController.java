package cn.wuweiblog.computertest.controller;

import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Jervain on 2016-11-18.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/login/handle")
    public String loginHandle(String num, String pwd, HttpSession session) {
        User user = userService.getUserByNum(num);
        if (user != null && user.getPassword() != null && user.getPassword().equals(pwd)) {
            user.setLastlogintime(new Date());
            userService.saveUser(user);
            session.setAttribute("user", user);
            return "redirect:/index/list";
        }
        return "redirect:/login";
    }

}
