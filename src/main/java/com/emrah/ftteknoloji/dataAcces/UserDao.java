package com.emrah.ftteknoloji.dataAcces;

import com.emrah.ftteknoloji.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,Integer> {
}
