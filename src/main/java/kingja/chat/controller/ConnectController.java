package kingja.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kingja.chat.form.FormCreate;
import kingja.chat.result.Result;
import kingja.chat.service.ConnectService;
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

    @PostMapping("/create")
    @ResponseBody
    public Result create(@RequestBody FormCreate formCreate) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("formCreate : " + formCreate.toString());
        connectService.create(formCreate);
        return Result.success("创建成功");
    }


}
