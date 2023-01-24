package com.myproject.mypet.controller;


import com.myproject.mypet.model.Comment;
import com.myproject.mypet.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment newComment = commentService.updateComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestBody Comment comment) {
        commentService.deleteComment(comment.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> allComments() {
        List<Comment> comment = commentService.allComments();
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<Comment> findCommentById(@RequestBody Comment comment) {
        Comment newComment = commentService.findCommentById(comment.getId());
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }


}
