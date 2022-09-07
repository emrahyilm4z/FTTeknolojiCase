package com.emrah.ftteknoloji.controller;

import com.emrah.ftteknoloji.business.CommentService;
import com.emrah.ftteknoloji.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/comment")
public class CommentsController {

    private CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Comment>> getAll() {
        return new ResponseEntity<List<Comment>>(this.commentService.getAll().getBody(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> add(@RequestBody Comment comment) {
        int lastIdOfItem = getAll().getBody().isEmpty() ? 0 : getAll().getBody().get(getAll().getBody().size()-1).getId() ;
        comment.setId(lastIdOfItem + 1);
        return new ResponseEntity<Comment>(this.commentService.add(comment).getBody(), HttpStatus.OK);
    }

    @GetMapping("/getProductIdComment")
    public ResponseEntity<List<String>> getByProductId(@RequestParam(name = "id") int id) {
        return this.commentService.getProductIdComment(id);
    }

    @GetMapping("/getUserComment")
    public ResponseEntity<List<String>> getUserComment(@RequestParam(name = "id") int id) {
        return this.commentService.getUserComment(id);
    }

    @GetMapping("/getBDPC")
    public ResponseEntity<List<String>> getDateBetweenProductComment(@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name = "productId") int productId) {
        return this.commentService.getDateProductComment(startDate, endDate, productId);
    }

    @GetMapping("/getBDUC")
    public ResponseEntity<List<String>> getDateBetweenUserComment(@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name = "userId") int userId) {
        return this.commentService.getDateUserComment(startDate, endDate, userId);
    }


}
