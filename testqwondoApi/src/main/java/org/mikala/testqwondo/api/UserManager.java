package org.mikala.testqwondo.api;

import org.mikala.testqwondo.api.model.Role;
import org.mikala.testqwondo.api.model.User;

public interface UserManager {
	public User getUser(Long userId);
	public User addUser(User user);
	public void deleteUser(User user);
	public void deleterUser(Long idUser);
	public User addRoleToUser(Role role,User user);
	public User removeRoleFromUser(Role role, User user);
}