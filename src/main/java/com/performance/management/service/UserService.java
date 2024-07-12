package com.performance.management.service;

import com.performance.management.entity.Usertable;
import com.performance.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void saveUser(Usertable user) {
        user.setCreatedatetime(Timestamp.from(Instant.now()));
        userRepository.save(user);
    }

    public boolean isEmailDuplicate(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isPhoneNumberDuplicate(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

    public boolean isEmpIdDuplicate(String empId) {
        return userRepository.findByEmpId(empId).isPresent();
    }


    public Usertable loginUser(Usertable user) {
        String password = user.getPassword();
        Usertable user1 = (Usertable) userRepository.findByEmail(user.getEmail()).orElse(null);
        if (user1 != null && user1.getPassword().equals(password)) {
            user1.setMessage("Login successful");
            user1.setPassword(null);
            return user1;
        }else {
            user.setMessage("Invalid credentials");
            return user;
        }
    }
}
