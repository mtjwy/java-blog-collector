package com.lamaryw.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamaryw.web.entity.Blog;
import com.lamaryw.web.entity.Item;
import com.lamaryw.web.entity.User;
import com.lamaryw.web.repository.BlogRepository;
import com.lamaryw.web.repository.ItemRepository;
import com.lamaryw.web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog);
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
}
