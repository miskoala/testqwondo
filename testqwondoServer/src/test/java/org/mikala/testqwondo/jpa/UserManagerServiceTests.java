package org.mikala.testqwondo.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.api.model.enums.Role;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(ApplicationConfig.class)
public class UserManagerServiceTests extends AbstractTransactionalTestNGSpringContextTests{
	
	@Autowired
	UserManagerService userManagerService;

	private Long userId;
	@BeforeClass
	@Rollback(false)
	public void beforeClass(){
		logger.info("Start testów w klasie UserManagerServiceTests");
		for (int i = 0; i <= 100; i++) {
			User user = new User("login"+i+"login", "password", "name"+i+"name", "email", "jabber");
			userManagerService.saveUser(user);
			logger.info("User zapisany-"+user.getName());
		}
	}
	@AfterClass
	public void afertClass(){
		logger.info("Koniec testów w klasie UserManagerServiceTests");
	}
	@Test
	@Rollback(false)
	public void showUsersTest(){
		try {
			
			int pageNr=0;
			Page<User> page=null;
			while(pageNr==0 || page.hasNext()){
				
				Pageable pageable=new PageRequest(pageNr++, 10);
				page = userManagerService.showUsers("Name2%name", pageable);
				logger.info("start page nr="+page.getNumber());
				List<User> userList=page.getContent();
				Iterator<User> pageIter = userList.iterator();
				while (pageIter.hasNext()) {
					User user = (User) pageIter.next();
					logger.info("Znaleziono-"+user.getName());
					
				}
				logger.info("end page nr="+page.getNumber());
			}
		} catch (Exception e) {
			logger.info(e.getCause().getMessage());
			throw e;
		}
	}
	
	
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	@Rollback(true)
	public void addUserValidate1Test() {
		try {
			User u=null;// = new User("", "", "", "", "");
			u=userManagerService.saveUser(u);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}	
	@Test(expectedExceptions=ConstraintViolationException.class)
	@Rollback(true)
	public void addUserValidateEmptyTest() {
		try {
			User u = new User("", "", "", "", "");
			u=userManagerService.saveUser(u);
		} catch (ConstraintViolationException e) {
			Assert.assertTrue(e.getConstraintViolations().size()==7);
			throw e;
		}
	}
	@Test(expectedExceptions=ConstraintViolationException.class)
	@Rollback(true)
	public void addUserValidateEmpty1Test() {
		try {
			User u = new User(null, null, null, null, null);
			u=userManagerService.saveUser(u);
		} catch (ConstraintViolationException e) {
			Assert.assertTrue(e.getConstraintViolations().size()==4);
			throw e;
		}
	}

	@Test(expectedExceptions=ConstraintViolationException.class)
	@Rollback(true)
	public void addUserValidateNameTest() {
		try {
			User u = new User("login", "password", null, "email", "jabber");
			u=userManagerService.saveUser(u);
			User u1 = new User("loginc", "passwordc", "", "emailc", "jabberc");
			u1=userManagerService.saveUser(u1);
			
		} catch (ConstraintViolationException e) {
			throw e;
		}
	}
	@Test
	@Rollback(true)
	public void addUserTest() {
		User u = new User("logina", "passworda", "namea", "emaila", "jabbera");
		u=userManagerService.saveUser(u);
		Assert.assertNotNull(userManagerService.getUser(u.getId()));
	}
	@Test
	@Rollback(true)
	public void getUserTest() {
		User u = new User("loginb", "passwordb", "nameb", "emailb", "jabberb");
		u=userManagerService.saveUser(u);
		User u1=userManagerService.getUser(u.getId());
		Assert.assertEquals(u1.getId(), u.getId());
	}
	@Test
	@Rollback(true)
	public void getUserNotExsistTest() {
		User u=userManagerService.getUser(new Long(-9999999));
		Assert.assertNull(u);
	}
	@Test
	@Rollback(true)
	public void deleteUserByUserTest() {
		User u = new User("login1", "password1", "name1", "email1", "jabber1");
		long userId=userManagerService.saveUser(u).getId();
		User u1=userManagerService.getUser(userId);
		userManagerService.deleteUser(u1);
		Assert.assertNull(userManagerService.getUser(userId));
	}
	@Test
	@Rollback(true)
	public void deleterByIdUserTest() {
		User u = new User("login2", "password2", "name2", "email2", "jabber2");
		long userId=userManagerService.saveUser(u).getId();
		User u1=userManagerService.getUser(userId);
		userManagerService.deleteUser(u1.getId());
		Assert.assertNull(userManagerService.getUser(userId));
	}
/*	@Test
	@Rollback(false)
	public void addRoleToUserTest() throws Exception {
		User u = new User("login3", "password3", "name3", "email3", "jabber3");
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
	}*/
	@Test(dependsOnMethods="addRoleToUserTest")
	@Rollback(false)
	public void userRolesTest(){
		User x= userManagerService.getUser(userId);
		Set<UserRole> roles = x.getUserRoles();
		Assert.assertEquals(roles.size(), 1);
		for (Iterator<UserRole> iterator = roles.iterator(); iterator.hasNext();) {
			UserRole userRole = (UserRole) iterator.next();
			Assert.assertEquals(Role.ADMIN, userRole.getRole());
		}
	}
/*	@Test
	@Rollback(false)
	public void removeRoleFromUserTest() {
		User u = new User("login5", "password5", "name5", "email5", "jabber5");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		u=userManagerService.removeRoleFromUser(Role.ADMIN, u);
		Assert.assertTrue(u.getUserRoles()==null || u.getUserRoles().size()==0);
		User x= userManagerService.getUser(u.getId());
		Assert.assertTrue(x.getUserRoles()==null || x.getUserRoles().size()==0);
		Assert.assertFalse(userManagerService.isUserHasRole(x, Role.ADMIN));
	}
	@Test
	@Rollback(true)
	public void hasRole1() {
		User u = new User("login4", "password4", "name4", "email4", "jabber4");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		Assert.assertTrue(u.getUserRoles()!=null && u.getUserRoles().size()==1);
		User x= userManagerService.getUser(u.getId());
		Assert.assertTrue(userManagerService.isUserHasRole(x, Role.ADMIN));
	}*/

/*	@Test
	@Rollback(true)
	public void hasRole2() {
		User u = new User("login6", "password6", "name6", "email6", "jabber6");
		userManagerService.saveUser(u);
		u=userManagerService.addRoleToUser(Role.ADMIN, u);
		User x= userManagerService.getUser(u.getId());
		Assert.assertFalse(userManagerService.isUserHasRole(x, Role.TESTER));
	}*/
}
