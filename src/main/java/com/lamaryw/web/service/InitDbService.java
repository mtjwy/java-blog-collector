package com.lamaryw.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamaryw.web.entity.Blog;
import com.lamaryw.web.entity.Item;
import com.lamaryw.web.entity.Role;
import com.lamaryw.web.entity.User;
import com.lamaryw.web.repository.BlogRepository;
import com.lamaryw.web.repository.ItemRepository;
import com.lamaryw.web.repository.RoleRepository;
import com.lamaryw.web.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogSpring = new Blog();
		blogSpring.setName("Spring");
		blogSpring.setUrl("http://spring.io/blog.atom");
		blogSpring.setUser(userAdmin);
		blogRepository.save(blogSpring);
		
		Item item1 = new Item();
		item1.setBlog(blogSpring);
		item1.setTitle("first");
		item1.setLink("https://spring.io/blog");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogSpring);
		item2.setTitle("second");
		item2.setLink("https://spring.io/blog");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		
	}
	
	
	
	
}
