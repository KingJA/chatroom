package kingja.chat.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:TODO
 * Create Time:2018/4/15 14:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@WebFilter()
public class CorsWebFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(CorsWebFilter.class);
    private List<String> filterPaths =new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterPaths.add("admin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String origin = request.getHeader("Origin");
        String headers = request.getHeader("Access-Control-Request-Headers");
        logger.error("headers:"+headers);
        if (origin == null) {
            origin = request.getHeader("Referer");
        }
        // 允许指定域访问跨域资源
        response.setHeader("Access-Control-Allow-Origin", origin);//带cookie的话不能为*
        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Max-Age", "3600");//预检命令的缓存时间
        //允许携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //允许请求头
        if (headers != null) {
            response.setHeader("Access-Control-Allow-Headers", headers);
        }

        response.setHeader("Access-Control-Expose-Headers", "*");
        logger.error("path:"+request.getServletPath());
        if(!request.getServletPath().contains("admin")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

//        String token = request.getHeader("token");
//        if (StringUtils.isEmpty(token)) {
//            response.setContentType("text/json");
//            /* 设置字符集为'UTF-8' */
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out = response.getWriter();
//            Result reponseBody = Result.error(CodeMsg.UN_LOGIINED);
//            out.write( new Gson().toJson(reponseBody));
//            out.flush();
//        }else{
//            logger.error("接收到token:"+token);
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}