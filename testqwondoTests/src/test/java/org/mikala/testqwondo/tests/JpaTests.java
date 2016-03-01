package org.mikala.testqwondo.tests;

import org.mikala.testqwondo.spring.repository.PlanRepository;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.web.config.SpringDataWebConfigurationMixin;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

//@SpringBootApplication
@SpringApplicationConfiguration(ApplicationConfig.class)
@Test
public class JpaTests extends AbstractTestNGSpringContextTests{
	
	@Autowired
	PlanRepository pr;
	//@Autowired
	//UserManagerService um;
	@Test
	public void testHome() throws Exception {
		pr.findAll();
		
	}
}
