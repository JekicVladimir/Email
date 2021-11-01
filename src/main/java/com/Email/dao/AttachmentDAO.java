package com.Email.dao;


import com.Email.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentDAO extends JpaRepository<Attachment, Integer> {


}
