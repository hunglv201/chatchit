package com.example.chatchit.api;

import com.example.chatchit.model.UserAtt;
import com.example.chatchit.model.Users;
import com.example.chatchit.repo.UserRepository;
import com.example.chatchit.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EndChat {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendMessageService sendMessageService;

    private static final Logger logger = LoggerFactory.getLogger(EndChat.class);

    @PostMapping("/endChat")
    public Boolean startChat(@RequestParam String id) {
        logger.info("end chat with id = {}" , id);
        Optional<Users> usedb = userRepository.findFirstByFbId(id);
        if (usedb.isPresent()) {
            if (usedb.get().getConnectId() != null) {
                endChatForUser(usedb.get().getConnectId());
                usedb.get().setConnectId(null);
                userRepository.save(usedb.get());
                sendMessageService.sendTexToMe("Bạn chưa kết được kết nối với người lạ id :" + usedb.get().getConnectId());
                sendMessageService.sendTexToOther("Người lạ đã kết thúc trò chuyện với bạn id: " + id);
                return true;
            } else {
                sendMessageService.sendTexToMe("Bạn chưa kết được kết nối với người lạ");
            }
        }
        return false;
    }

    private boolean endChatForUser(String id) {
        Optional<Users> usedb = userRepository.findFirstByFbId(id);
        if (usedb.isPresent()) {
            if (usedb.get().getConnectId() != null) {
                usedb.get().setConnectId(null);
                userRepository.save(usedb.get());
                return true;
            }
        }
        return false;
    }
}
