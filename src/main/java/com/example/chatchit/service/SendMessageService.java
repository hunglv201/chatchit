package com.example.chatchit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendMessageService {
    public Boolean sendTexToMe(String mess) {
        log.info("TO ME:---" + mess);
        return true;
    }

    public Boolean sendTexToOther(String mess) {
        log.info("TO OTHOR: -----" + mess);
        return true;
    }
}
