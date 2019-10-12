package kingja.chat.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;


/**
 * Description：TODO
 * Create Time：2018/1/20 11:11
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Aspect
@Component
@Slf4j
public class ChatAspect {

    @Pointcut("execution(public * kingja.chat.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doLog() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
    }

}
