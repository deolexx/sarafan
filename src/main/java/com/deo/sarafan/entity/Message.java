package com.deo.sarafan.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(of = {"id"})
@Entity
@Table
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.IdName.class)
    private long id;
     private String text;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(Views.FullMessage.class)
    private User author;

    @OneToMany(mappedBy = "message", orphanRemoval = true)
    @JsonView(Views.FullMessage.class)
    private List<Comment> comments;

    @JsonView(Views.FullMessage.class)
    private String link;
    @JsonView(Views.FullMessage.class)
    private String linkTitle;
    @JsonView(Views.FullMessage.class)
    private String linkDescription;
    @JsonView(Views.FullMessage.class)
    private String linkCover ;
}
