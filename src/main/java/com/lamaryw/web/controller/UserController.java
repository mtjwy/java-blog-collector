package com.lamaryw.web.controller;

import java.security.Principal;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lamaryw.web.entity.Blog;
import com.lamaryw.web.entity.User;
import com.lamaryw.web.service.BlogService;
import com.lamaryw.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}
	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {//principal is an object in session, which contains the name of the user
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "account";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal) {//use principal to get info about which user want to add a blog
		if (result.hasErrors()) {
			return account(model, principal);
		}
		
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";

		
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		
		return "redirect:/account.html";

	}
	
	
}
