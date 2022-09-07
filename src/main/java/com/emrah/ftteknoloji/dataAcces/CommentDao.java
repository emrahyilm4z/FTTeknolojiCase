package com.emrah.ftteknoloji.dataAcces;

import com.emrah.ftteknoloji.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDao extends MongoRepository<Comment,Integer > {
}
