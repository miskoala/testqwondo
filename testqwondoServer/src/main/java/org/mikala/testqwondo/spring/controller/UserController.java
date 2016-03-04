package org.mikala.testqwondo.spring.controller;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/x")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/findByNameLoginLike", method=RequestMethod.GET)
	public Page<User> findByNameOrLoginLike(
			@RequestParam(name="name", defaultValue="%", required=false) String name,
			@RequestParam(name="login", defaultValue="%", required=false) String login,
			@RequestParam(name="page", defaultValue="0", required=false) String page,
			@RequestParam(name="size", defaultValue="10", required=false) String size) {
		
		return userRepository.findByNameAndLoginLike(name, login, new PageRequest(new Integer(page), new Integer(size)));
	}

}
