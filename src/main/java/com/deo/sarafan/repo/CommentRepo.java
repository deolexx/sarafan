package com.deo.sarafan.repo;

import com.deo.sarafan.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
