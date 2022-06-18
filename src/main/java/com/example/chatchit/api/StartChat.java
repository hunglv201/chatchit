package com.example.chatchit.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StartChat {
    private static final Logger logger = LoggerFactory.getLogger(StartChat.class);

    @PostMapping("/startchat")
    public void startChat(@RequestBody UserAtt req) {
        logger.info(req.toString());
    }
}
