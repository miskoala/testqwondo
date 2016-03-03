package org.mikala.testqwondo.api;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserManager {
	public User getUser(Long userId);
	public User saveUser(User user);
	public void deleteUser(User user);
	public void deleteUser(Long idUser);
	public User addRoleToUser(Role role,User user);
	public User removeRoleFromUser(Role role, User user);
	public boolean isUserHasRole(User user,Role role);
	
	Page<User> showUsers(String name, Pageable pageable);
}
