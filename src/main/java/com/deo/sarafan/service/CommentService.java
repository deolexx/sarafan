package com.deo.sarafan.service;

import com.deo.sarafan.entity.Comment;
import com.deo.sarafan.entity.User;
import com.deo.sarafan.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService  {

private final CommentRepo commentRepo;


    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        commentRepo.save(comment);

        return comment;
    }
}
