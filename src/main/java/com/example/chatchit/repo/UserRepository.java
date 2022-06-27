package com.example.chatchit.repo;

import com.example.chatchit.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findFirstByFbId(String id);

    Optional<Users> findFirstByQueueAndAndBlockedAndFbIdNotLike(int queue, int block, String id);
}
