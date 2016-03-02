package org.mikala.testqwondo.jpa;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.mikala.testqwondo.api.model.Role;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(ApplicationConfig.class)
public class UserManagerServiceTests extends AbstractTestNGSpringContextTests{
	
	@Autowired
	UserManagerService userManagerService;

	private Long userId;

	@AfterClass
	public void afertClass(){
		logger.info("Koniec testów w klasie UserManagerServiceTests");
	}
	
	@Test(expectedExceptions=ConstraintViolationException.class)
	public void addUserValidateLoginTest() {
		try {
			User u = new User("", "", "", "", "");
			u=userManagerService.saveUser(u);
		} catch (ConstraintViolationException e) {
			throw e;
		}
	}
	@Test
	public void addUserTest() {
		User u = new User("login", "password", "name", "email", "jabber");
		u=userManagerService.saveUser(u);
		Assert.assertNotNull(userManagerService.getUser(u.getId()));
	}
	@Test
	public void getUserTest() {
		User u = new User("login", "password", "name", "email", "jabber");
		u=userManagerService.saveUser(u);
		User u1=userManagerService.getUser(u.getId());
		Assert.assertEquals(u1.getId(), u.getId());
	}
	@Test
	public void getUserNotExsistTest() {
		User u=userManagerService.getUser(new Long(-9999999));
		Assert.assertNull(u);
	}
	@Test
	public void deleteUserByUserTest() {
		User u = new User("login", "password", "name", "email", "jabber");
		long userId=userManagerService.saveUser(u).getId();
		User u1=userManagerService.getUser(userId);
		userManagerService.deleteUser(u1);
		Assert.assertNull(userManagerService.getUser(userId));
	}
	@Test
	public void deleterByIdUserTest() {
		User u = new User("login", "password", "name", "email", "jabber");
		long userId=userManagerService.saveUser(u).getId();
		User u1=userManagerService.getUser(userId);
		userManagerService.deleteUser(u1.getId());
		Assert.assertNull(userManagerService.getUser(userId));
	}
	@Test
	public void addRoleToUserTest() throws Exception {
		User u = new User("login", "password", "name", "email", "jabber");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		userId=u.getId();
		User x= userManagerService.getUser(u.getId());
		Set<UserRole> roles = x.getUserRoles();
		Assert.assertEquals(roles.size(), 1);
		for (Iterator<UserRole> iterator = roles.iterator(); iterator.hasNext();) {
			UserRole userRole = (UserRole) iterator.next();
			Assert.assertEquals(Role.ADMIN, userRole.getRole());
		}
	}
	@Test(dependsOnMethods="addRoleToUserTest")
	public void userRolesTest(){
		User x= userManagerService.getUser(userId);
		Set<UserRole> roles = x.getUserRoles();
		Assert.assertEquals(roles.size(), 1);
		for (Iterator<UserRole> iterator = roles.iterator(); iterator.hasNext();) {
			UserRole userRole = (UserRole) iterator.next();
			Assert.assertEquals(Role.ADMIN, userRole.getRole());
		}
	}
	@Test
	public void hasRole1() {
		User u = new User("login", "password", "name", "email", "jabber");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		Assert.assertTrue(u.getUserRoles()!=null && u.getUserRoles().size()==1);
		User x= userManagerService.getUser(u.getId());
		Assert.assertTrue(userManagerService.isUserHasRole(x, Role.ADMIN));
	}
	@Test
	public void removeRoleFromUserTest() {
		User u = new User("login", "password", "name", "email", "jabber");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		u=userManagerService.removeRoleFromUser(Role.ADMIN, u);
		Assert.assertTrue(u.getUserRoles()==null || u.getUserRoles().size()==0);
		User x= userManagerService.getUser(u.getId());
		Assert.assertTrue(x.getUserRoles()==null || x.getUserRoles().size()==0);
		Assert.assertFalse(userManagerService.isUserHasRole(x, Role.ADMIN));
	}
	@Test
	public void hasRole2() {
		User u = new User("login", "password", "name", "email", "jabber");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		User x= userManagerService.getUser(u.getId());
		Assert.assertFalse(userManagerService.isUserHasRole(x, Role.TESTER));
	}
}
