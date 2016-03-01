package org.mikala.testqwondo.jpa;

import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

//@SpringBootApplication
@SpringApplicationConfiguration(value=ApplicationConfig.class)
//@IntegrationTest("server.port:9009")
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {UserManagerService.class})
public class UserManagerServiceTests extends AbstractTransactionalTestNGSpringContextTests{
	
	@Autowired
	//@Qualifier("userManagerService")
	UserManagerService userManagerService;
	@Test
	public void gerUserTest() throws Exception {
		userManagerService.getUser(1L);
	}
}
