package kingja.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import kingja.chat.access.AccessLimit;
import kingja.chat.form.FormConnect;
import kingja.chat.form.FormCreate;
import kingja.chat.redis.RedisService;
import kingja.chat.redis.UserKey;
import kingja.chat.result.Result;
import kingja.chat.service.ConnectService;
import kingja.chat.vo.ConnectInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/")
@Slf4j
public class ConnectController {

    @Autowired
    ConnectService connectService;

    @Autowired
    RedisService redisService;

    @PostMapping("/create")
    @ResponseBody
    public Result create(@RequestBody FormCreate formCreate) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("formCreate : " + formCreate.toString());
        redisService.set(UserKey.getById,"1","001");
        return Result.success(connectService.create(formCreate));
    }

    @PostMapping("/connect")
    @ResponseBody
    public Result connect(@RequestBody FormConnect formConnect, HttpServletResponse response) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("formConnect : " + formConnect.toString());
        connectService.connect(formConnect,response);
        return Result.success("连接成功");
    }
}
