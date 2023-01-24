package com.myproject.mypet.repo;

import com.myproject.mypet.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CommentResository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentById(Long id);
}
