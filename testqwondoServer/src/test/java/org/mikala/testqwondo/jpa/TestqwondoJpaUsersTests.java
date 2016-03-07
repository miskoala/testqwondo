package org.mikala.testqwondo.jpa;

import java.util.Iterator;
import java.util.Set;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.api.model.enums.Role;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.mikala.testqwondo.spring.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootApplication
@SpringApplicationConfiguration(ApplicationConfig.class)
public class TestqwondoJpaUsersTests extends AbstractTestNGSpringContextTests{
	@Autowired
	UserRepository ur;
	@Autowired
	UserRoleRepository urr;
	@Test
	public void testHome() throws Exception {
		
		User u=new User("login", "password", "name", "email", "jabber");
		ur.save(u);
		UserRole userRoleAdmin = new UserRole(u,Role.ADMIN);
		userRoleAdmin=urr.save(userRoleAdmin);

		UserRole userRoleTester = new UserRole(u, Role.TEST_MANAGER);
		userRoleTester=urr.save(userRoleTester);
		
		u.addUserRole(userRoleAdmin);
		u.addUserRole(userRoleTester);
		u=ur.save(u);
		
		Set<UserRole> uRoles = u.getUserRoles();
		for (Iterator<UserRole> iterator = uRoles.iterator(); iterator.hasNext();) {
			UserRole userRole = (UserRole) iterator.next();
			System.out.println(userRole);
		}

		urr.delete(userRoleAdmin.getId());
		urr.delete(userRoleTester.getId());
		//u.removeUserRole(userRoleAdmin);
		//u.removeUserRole(userRoleTester);
		ur.delete(u);	
		u.getId();
	}
}
