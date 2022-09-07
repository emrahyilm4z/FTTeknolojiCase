package com.emrah.ftteknoloji.controller;

import com.emrah.ftteknoloji.business.UserService;
import com.emrah.ftteknoloji.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user") // base address => localhost:8080/{user}
public class UsersController {

    private UserService userService ;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<List<User>>(this.userService.getAll().getBody(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        int lastIdOfItem = getAll().getBody().isEmpty() ? 0 : getAll().getBody().get(getAll().getBody().size()-1).getId() ;
        user.setId(lastIdOfItem + 1);
        return new ResponseEntity<User>(this.userService.add(user).getBody(), HttpStatus.OK);
    }
}
