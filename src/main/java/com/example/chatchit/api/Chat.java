package com.example.chatchit.api;

import com.example.chatchit.model.SendChat;
import com.example.chatchit.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class Chat {

    @Autowired
    private UserRepository userRepository;

   private static final Logger logger = LoggerFactory.getLogger(Chat.class);

    @PostMapping("/sendChat")
    public SendChat startChat(SendChat req) {
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8080/api/users", String.class);
//        logger.debug(res.toString());
        logger.info(req.toString());
        return req;
    }

    @GetMapping("/test-api")
    public void t1() {
        RestTemplate restTemplate = new RestTemplate();
        SendChat reqabcduest = new SendChat("100", "");
        ResponseEntity<SendChat> res = restTemplate.postForEntity("http://localhost:8080/api/sendchat",reqabcduest, SendChat.class);
        logger.debug(res.getBody().toString());
    }
}
