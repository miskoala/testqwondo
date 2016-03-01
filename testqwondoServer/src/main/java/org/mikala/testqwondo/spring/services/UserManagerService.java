package org.mikala.testqwondo.spring.services;

import org.mikala.testqwondo.api.UserManager;
import org.mikala.testqwondo.api.model.Role;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value="userManagerService")
public class UserManagerService implements UserManager{

	@Autowired
	UserRepository userRepository;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public User getUser(Long userId) {
		
		return userRepository.findOne(userId);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleterUser(Long idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User addRoleToUser(Role role, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeRoleFromUser(Role role, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
