package com.simplesrm.member.repository;

import com.simplesrm.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);

    Optional<User> findByEmailAuthKey(String emailAuthKey);

}
