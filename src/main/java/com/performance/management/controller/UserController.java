package com.performance.management.controller;

import com.performance.management.DTO.UserDTO;
import com.performance.management.entity.Roles;
import com.performance.management.entity.Usertable;
import com.performance.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Usertable> createUser(@RequestBody UserDTO user) {
        Usertable usertable = new Usertable();
        if (userService.isEmailDuplicate(user.getEmail())) {
            user.setMessage("Email already exists");
            return ResponseEntity.badRequest().body(usertable);
        }
        if (userService.isPhoneNumberDuplicate(user.getPhoneNumber())) {
            user.setMessage("Phone number already exists");
            return ResponseEntity.badRequest().body(usertable);
        }
//        if(userService.isEmpIdDuplicate(user.getEmpId())) {
//            user.setMessage("Employee Id already exists");
//            return ResponseEntity.badRequest().body(user);
//        }

        userService.saveUser(user);
        usertable.setMessage("User created successfully");
        return ResponseEntity.ok(usertable);
    }

    @PostMapping("/login")
    public ResponseEntity<Usertable> loginUser(@RequestBody Usertable user) {
        return ResponseEntity.ok(userService.loginUser(user));
    }

    @GetMapping("/getRoles")
    public ResponseEntity<List<Roles>> getRoles() {
        return ResponseEntity.ok(userService.getRoles());
    }
}
