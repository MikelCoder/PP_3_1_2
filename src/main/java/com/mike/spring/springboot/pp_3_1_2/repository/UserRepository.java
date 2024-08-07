package com.mike.spring.springboot.pp_3_1_2.repository;

import com.mike.spring.springboot.pp_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}