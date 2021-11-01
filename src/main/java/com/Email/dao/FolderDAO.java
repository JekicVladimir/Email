package com.Email.dao;

import com.Email.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderDAO extends JpaRepository<Folder, Integer> {


}
