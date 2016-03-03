package org.mikala.testqwondo.spring.controller;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserManagerService userManagerService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/findAll")
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	@RequestMapping(value="/findByNameLikeIgnoreCase")
	public Page<User> findByNameLikeIgnoreCase(String name, Pageable pageable) {
		return userRepository.findByNameLikeIgnoreCase(name, pageable);
	}

}
