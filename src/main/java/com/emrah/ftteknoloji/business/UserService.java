package com.emrah.ftteknoloji.business;

import com.emrah.ftteknoloji.dataAcces.UserDao;
import com.emrah.ftteknoloji.entities.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity<User> add(User user) {
        this.userDao.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.userDao.findAll(), HttpStatus.OK);
    }
}
