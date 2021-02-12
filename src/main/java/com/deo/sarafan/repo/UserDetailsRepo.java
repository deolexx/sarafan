package com.deo.sarafan.repo;

import com.deo.sarafan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {
}
