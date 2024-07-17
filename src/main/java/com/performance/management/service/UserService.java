package com.performance.management.service;

import com.performance.management.DTO.UserDTO;
import com.performance.management.entity.Roles;
import com.performance.management.entity.Usertable;
import com.performance.management.repository.RolesRespository;
import com.performance.management.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RolesRespository rolesRespository;

    @Autowired
    ModelMapper modelMapper;

    public void saveUser(UserDTO user) {
       Roles roles = new Roles();
       roles.setId(user.getRoleFid());
       Usertable usertable = modelMapper.map(user, Usertable.class);
       usertable.setCreatedatetime(Timestamp.from(Instant.now()));
       usertable.setRole(roles);
       userRepository.save(usertable);
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

    public List<Roles> getRoles() {
        return rolesRespository.findAll();
    }
}
