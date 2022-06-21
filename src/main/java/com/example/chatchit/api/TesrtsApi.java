package com.example.chatchit.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TesrtsApi {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity getUsess() {
        List<Users> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
