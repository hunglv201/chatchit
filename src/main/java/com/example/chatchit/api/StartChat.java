package com.example.chatchit.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StartChat {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(StartChat.class);

    @PostMapping("/startchat")
    public void startChat(UserAtt req) {
        logger.info(req.toString());
        Optional<Users> usedb = userRepository.findFirstByFbId(req.getId());
        if (usedb.isPresent())
            return;
        Users user = new Users();
        user.setFbId(req.getId());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setGender(req.getGender());
        user.setAvatar(req.getAvatar());
        userRepository.save(user);
    }
}
