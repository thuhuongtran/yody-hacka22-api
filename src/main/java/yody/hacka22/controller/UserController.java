package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dto.LoginRequest;
import yody.hacka22.entity.User;
import yody.hacka22.repository.UserRepository;

import java.util.Optional;

@Controller
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepository userRepository;
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User response = userRepository.createUser(user);
        if (response!=null){
            response.setPassWord("");
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

    @GetMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userRepository.verify(loginRequest));
    }

}
