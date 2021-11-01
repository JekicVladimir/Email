package com.Email.dao;

import com.Email.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDAO extends JpaRepository<Photo, Integer> {


}
