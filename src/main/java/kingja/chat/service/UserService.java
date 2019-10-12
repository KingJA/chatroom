package kingja.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kingja.chat.dao.UserDao;
import kingja.chat.exception.ResultException;
import kingja.chat.form.FormRegister;
import kingja.chat.result.CodeMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2019/10/12 0012 下午 2:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserDao userDao;

    public void register(FormRegister formRegister) {
        int count = userDao.hasUser(formRegister.getUsername());
        if (count > 0) {
            throw new ResultException(CodeMsg.HAS_REGISTERED);
        }
        int count = userDao.addUser(formRegister);
        log.info("count:"+count);

    }
}
