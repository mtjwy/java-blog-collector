package com.lamaryw.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamaryw.web.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
