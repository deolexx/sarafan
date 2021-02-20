package com.deo.sarafan.service;


import com.deo.sarafan.dto.EventType;
import com.deo.sarafan.dto.ObjectType;
import com.deo.sarafan.entity.Comment;
import com.deo.sarafan.entity.User;
import com.deo.sarafan.entity.Views;
import com.deo.sarafan.repo.CommentRepo;
import com.deo.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;


@Service
public class  CommentService  {

private final CommentRepo commentRepo;
private final BiConsumer<EventType, Object> wsSender;



    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender ) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT , Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
