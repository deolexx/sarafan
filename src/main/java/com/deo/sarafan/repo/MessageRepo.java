package com.deo.sarafan.repo;

import com.deo.sarafan.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository <Message, Long> {

}
