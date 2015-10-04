package com.lamaryw.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamaryw.web.entity.Blog;
import com.lamaryw.web.entity.User;


public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
}
