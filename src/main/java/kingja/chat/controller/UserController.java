package kingja.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kingja.chat.form.FormLogin;
import kingja.chat.form.FormRegister;
import kingja.chat.result.Result;
import kingja.chat.service.UserService;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody FormLogin formLogin) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userService.login(formLogin);
        return Result.success("登录成功");
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody FormRegister formRegister) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userService.register(formRegister);
        return Result.simpleSuccess("注册成功");
    }

    @RequestMapping("/to_register")
    public String register() {
        return "register";
    }

    @RequestMapping("/to_login")
    public String login() {
        return "login";
    }
}
