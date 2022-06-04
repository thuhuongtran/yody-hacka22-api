package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.entity.User;
import yody.hacka22.repository.UserRepository;

import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User response = userRepository.createUser(user);
        if (response!=null){
            response.setPassword("");
            return ResponseEntity.ok(response);
        }
        else return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("view/{id}")
    public ResponseEntity<User> viewProfile(@PathVariable String id){
        Optional<User> response = userRepository.getUser(id);
        if (response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        else return ResponseEntity.noContent().build();
    }
}
