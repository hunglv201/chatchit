package com.example.chatchit.api;

import com.example.chatchit.model.UserAtt;
import com.example.chatchit.model.Users;
import com.example.chatchit.repo.UserRepository;
import com.example.chatchit.service.SendMessageService;
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

    @Autowired
    private SendMessageService sendMessageService;

    private static final Logger logger = LoggerFactory.getLogger(StartChat.class);

    @PostMapping("/startchat")
    public Boolean startChat(UserAtt req) {
        logger.info(req.toString());
        Optional<Users> usedb = userRepository.findFirstByFbId(req.getId());
        if (usedb.isPresent()) {
            randomConnectToUser(usedb.get());
        }

        Users user = new Users();
        user.setFbId(req.getId());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setGender(req.getGender());
        user.setAvatar(req.getAvatar());
        user = userRepository.save(user);
        randomConnectToUser(user);
        return false;
    }

    private boolean randomConnectToUser(Users userdb ) {
        if (userdb.getConnectId() != null) {
            return sendMessageService.sendTexToMe("Bạn đang trong cuộc trò chuyện. hãy kết thúc để bắt đầu cuộc trò chuyện mới!");
        } else if (userdb.getBlocked() == 1) {
            return sendMessageService.sendTexToMe("Bạn đã bị block bởi quản lý. liên kệ để mở mở lại tài khoản.");
        }

        Optional<Users> usersConnect = userRepository.findFirstByQueueAndAndBlockedAndFbIdNotLike(1, 0, userdb.getFbId());
        if (usersConnect.isPresent()) {
            Users u = usersConnect.get();
            userdb.setConnectId(u.getFbId());
            userdb.setQueue(0);

            u.setConnectId(userdb.getFbId());
            u.setQueue(0);
            userRepository.save(u);
            userRepository.save(userdb);

            sendMessageService.sendTexToMe("Bạn đã kết nối với người lạ có id :" + u.getFbId());
            sendMessageService.sendTexToOther("Bạn đã kết nối với người lạ có id :" + u.getConnectId());
        } else {
            userdb.setQueue(1);
            userRepository.save(userdb);
            sendMessageService.sendTexToMe("Đang tìm kiếm ...");
        }
        return true;
    }
}
