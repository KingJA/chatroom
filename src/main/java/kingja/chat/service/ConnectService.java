package kingja.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kingja.chat.dao.ConnectDao;
import kingja.chat.exception.ResultException;
import kingja.chat.form.FormCreate;
import kingja.chat.result.CodeMsg;
import kingja.chat.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2019/10/12 0012 下午 2:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
@Slf4j
public class ConnectService {

    public static final int MAX_COUNT = 20;
    public static final int MIN_COUNT = 2;
    public static final int DEFAULT_COUNT = 20;

    @Autowired
    ConnectDao connectDao;


    public void create(FormCreate formCreate) {
        //1.判断该用户是否拥有创建权限
        //2.判断该用户创建的连接数是否有余量
        //3.开始创建连接
        boolean needLimitCount = formCreate.isNeedLimitCount();
        int maxCount = formCreate.getMaxCount();
        int count;
        if (needLimitCount) {
            if (maxCount < MIN_COUNT || maxCount > MAX_COUNT) {
                throw new ResultException(CodeMsg.CONNECT_COUNT_ERROR);
            }
        }
        count = connectDao.create(UuidUtil.uuid(), UuidUtil.uuid(), formCreate.getFingerprint(), formCreate.getPassword(),
                needLimitCount ? maxCount : DEFAULT_COUNT, formCreate.isNeedCheck() ? 1 : 0);
        if (count == 0) {
            throw new ResultException(CodeMsg.CONNECT_CREATE_ERROR);
        }
    }
}
