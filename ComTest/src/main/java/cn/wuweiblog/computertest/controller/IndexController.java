package cn.wuweiblog.computertest.controller;

import cn.wuweiblog.computertest.annotation.Token;
import cn.wuweiblog.computertest.bean.User;
import cn.wuweiblog.computertest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jervain on 2016-11-17.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    @RequestMapping("/index/list")
    public String list() {
        return "list";
    }

    @Token(save = true)
    @RequestMapping("/index/add")
    public String add() {
        return "add";
    }

    @Token(remove = true)
    @RequestMapping("/index/add/handle")
    public String addHandle(User user) {
        if (!user.getNum().equals("")) {
            userService.addUser(user);
            return "redirect:/index/list";
        }
        return "redirect:/index/add";
    }


    @Token(save = true)
    @RequestMapping("/index/modify")
    public String modify(Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "modify";
    }


    @Token(remove = true)
    @RequestMapping("/index/modify/handle")
    public String modifyHandle(User user) {
        if (!user.getNum().equals("")) {
            userService.saveUser(user);
            return "redirect:/index/list";
        }
        return "redirect:/index/modify?id="+user.getId();
    }


}
