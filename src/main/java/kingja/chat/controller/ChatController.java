package kingja.chat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/chatroom")
public class ChatController {

    @RequestMapping("/home")
    public String thymeleaf(Model model) {
        model.addAttribute("loginName", "kingja");
        return "chatroom";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginName", "kingja");
        return "login";
    }
}
