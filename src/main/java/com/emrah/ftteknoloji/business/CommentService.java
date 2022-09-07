package com.emrah.ftteknoloji.business;

import com.emrah.ftteknoloji.dataAcces.CommentDao;
import com.emrah.ftteknoloji.entities.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    public final CommentDao commentDao;


    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public ResponseEntity<Comment> add(Comment comment) {
        this.commentDao.save(comment);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    public ResponseEntity<List<Comment>> getAll() {
        return new ResponseEntity<>(this.commentDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getProductIdComment(int productId) {
        List<String> array = new ArrayList<>();

        getAll().getBody().forEach((item) -> {
            if (item.getProductId() == productId) {
                array.add(item.getComment());
            }
        });
        return new ResponseEntity<>(array, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getUserComment(int userId) {
        List<String> array = new ArrayList<>();
        getAll().getBody().forEach((item -> {
            if (item.getUserId() == userId) {
                array.add(item.getComment());
            }
        }));
        return new ResponseEntity<>(array, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getDateProductComment(String startDate, String endDate, int productId) {
        List<String> array = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
        getAll().getBody().forEach((item -> {
            if (item.getProductId() == productId && item.getCommentDate().compareTo(parseStartDate) > 0 && item.getCommentDate().compareTo(parseEndDate) < 0) {
                array.add(item.getComment());
            }
        }));
        return new ResponseEntity<>(array, HttpStatus.OK);
    }
    public ResponseEntity<List<String>> getDateUserComment(String startDate, String endDate, int userId) {
        List<String> array = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
        getAll().getBody().forEach((item -> {
            if (item.getUserId() == userId && item.getCommentDate().compareTo(parseStartDate) > 0 && item.getCommentDate().compareTo(parseEndDate) < 0) {
                array.add(item.getComment());
            }
        }));
        return new ResponseEntity<>(array, HttpStatus.OK);
    }
}
