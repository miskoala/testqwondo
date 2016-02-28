package org.mikala.testqwondo.tests;

import org.mikala.testqwondo.jpa.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootApplication
@SpringApplicationConfiguration(ApplicationConfig.class)

public class JpaTests extends AbstractTestNGSpringContextTests{
	
	@Autowired
	PlanRepository pr;
	@Test
	public void testHome() throws Exception {
		pr.findAll();
		
	}
}
