package com.Email.dao;

import com.Email.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleDAO extends JpaRepository<Rule, Integer> {


}
