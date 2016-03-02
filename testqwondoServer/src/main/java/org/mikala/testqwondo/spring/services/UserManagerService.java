package org.mikala.testqwondo.spring.services;

import org.mikala.testqwondo.api.UserManager;
import org.mikala.testqwondo.api.model.Role;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.api.model.UserRoleId;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.mikala.testqwondo.spring.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "userManagerService")
public class UserManagerService implements UserManager {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public User getUser(Long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User saveUser(User user) {
		if(user==null) 
			return null;
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public void deleteUser(Long idUser) {
		userRepository.delete(idUser);
	}

	@Override
	public User addRoleToUser(Role role, User user) {
		if (role == null || user == null || user.getId() == null)
			return null;
		UserRoleId userRoleId = new UserRoleId(user.getId(), role);
		UserRole userRole = userRoleRepository.findOne(userRoleId);
		if (userRole == null) {
			userRole = new UserRole(userRoleId, user);
			userRoleRepository.save(userRole);
			user.addUserRole(userRole);
			userRepository.save(user);
		}
		return userRepository.findOne(user.getId());
	}

	@Override
	public User removeRoleFromUser(Role role, User user) {
		if (role == null || user == null || user.getId() == null)
			return user;
		if(!isUserHasRole(user, role)) 
			return user;
		UserRoleId userRoleId = new UserRoleId(user.getId(), role);
		UserRole userRole=userRoleRepository.findOne(userRoleId);
		user.removeUserRole(userRole);
		user=userRepository.save(user);
		//userRoleRepository.delete(userRoleId);
		return user;
	}

	@Override
	public boolean isUserHasRole(User user, Role role) {
		if (user == null || role == null)
			return false;
		if (userRoleRepository.findOne(new UserRoleId(user.getId(), role)) != null)
			return true;
		return false;
	}
}
