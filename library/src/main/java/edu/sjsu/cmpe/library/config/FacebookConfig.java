package edu.sjsu.cmpe.library.config;

/**
 * Created with IntelliJ IDEA.
 * User: shankey
 * Date: 11/9/13
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableInMemoryConnectionRepository;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.config.annotation.EnableFacebook;

@EnableFacebook(appId="someAppId", appSecret="shhhhhh!!!")
@EnableInMemoryConnectionRepository
public class FacebookConfig {

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

    @Bean
    public UserIdSource userIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "testuser";
            }
        };
    }

}