package org.mikala.testqwondo.jpa;

import org.mikala.testqwondo.spring.repository.UserRepository;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootApplication
@SpringApplicationConfiguration(ApplicationConfig.class)
//@IntegrationTest("server.port:9009")
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {UserManagerService.class})
public class UserManagerServiceTests extends AbstractTestNGSpringContextTests{
	//@Autowired
	//@Qualifier("userManagerService")
	UserManagerService userManagerService;
	@Test
	public void gerUserTest() throws Exception {
		userManagerService.getUser(1L);
	}
}
