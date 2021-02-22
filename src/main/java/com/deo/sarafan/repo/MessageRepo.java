package com.deo.sarafan.repo;

import com.deo.sarafan.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MessageRepo extends JpaRepository <Message, Long> {

    @EntityGraph(attributePaths = { "comments"})
    Pageable<Message> findAll(Pageable pageable);
}
