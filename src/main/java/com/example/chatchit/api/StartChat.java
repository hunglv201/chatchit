package com.example.chatchit.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StartChat {
    private static final Logger logger = LoggerFactory.getLogger(StartChat.class);

    @PostMapping("/startchat")
    public void startChat( UserAtt req) {
        logger.info(req.toString());
    }
}
