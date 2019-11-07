package kingja.chat.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Description:编写一个WebSocketConfig配置类，注入对象ServerEndpointExporter,这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
 * Create Time:2019/10/11 0011 上午 8:45
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}