package com.myproject.mypet.service;

import com.myproject.mypet.model.Comment;
import com.myproject.mypet.repo.CommentResository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentResository commentResository;

    @Autowired
    public CommentService(CommentResository commentResository) {
        this.commentResository = commentResository;
    }


    public Comment addComment(Comment comment) {
        return commentResository.save(comment);
    }

    public Comment findCommentById(Long id) {
        return commentResository.findCommentById(id)
                .orElseThrow();
    }

    public Comment updateComment(Comment comment) {
        return commentResository.save(comment);
    }

    public void deleteComment(Long id) {
        commentResository.deleteById(id);
    }

    public List<Comment> allComments() {
        return commentResository.findAll();
    }

}
