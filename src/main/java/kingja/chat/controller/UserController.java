package kingja.chat.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(FormLogin formLogin) {
        logger.info("Username: "+formLogin.getUsername());
        logger.info("Password: "+formLogin.getPassword());
        return Result.success("登录成功2");
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(FormRegister formRegister) {
        logger.info("Username: "+formRegister.getUsername());
        logger.info("Password: "+formRegister.getPassword());

        userService.register(formRegister);
        return Result.success("注册成功");
    }
}
