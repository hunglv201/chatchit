//package com.example.chatchit.config;
//
//import com.github.messenger4j.Messenger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Config {
//
//    @Bean
//    public Messenger messenger(@Value("${messenger4j.pageAccessToken}") String pageAccessToken,
//                               @Value("${messenger4j.appSecret}") final String appSecret,
//                               @Value("${messenger4j.verifyToken}") final String verifyToken) {
//        return Messenger.create(pageAccessToken, appSecret, verifyToken);
//    }
//}
