package com.Email.dao;

import com.Email.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);

}

