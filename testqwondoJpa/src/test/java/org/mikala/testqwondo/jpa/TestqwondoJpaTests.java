package org.mikala.testqwondo.jpa;

import java.util.Date;
import java.util.Set;

import org.mikala.testqwondo.api.model.Plan;
import org.mikala.testqwondo.api.model.PlanStatus;
import org.mikala.testqwondo.api.model.PlanType;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.jpa.repository.PlanRepository;
import org.mikala.testqwondo.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootApplication
@SpringApplicationConfiguration(ApplicationConfig.class)
public class TestqwondoJpaTests extends AbstractTestNGSpringContextTests{
	@Autowired
	PlanRepository pr;
	@Autowired
	UserRepository ur;
	@Test
	public void testHome() throws Exception {
		User u=new User("login", "password", "name", "email", "jabber");
		ur.save(u);
		Plan p= new Plan("name1", "system", "systemversion", new Date(), PlanType.P, PlanStatus.N, new Date(), new Date(), u);
		pr.save(p);
		Plan p1= new Plan("name2", "system", "systemversion", new Date(), PlanType.P, PlanStatus.A, new Date(), new Date(), u);
		pr.save(p1);
		Plan p2= new Plan("name3", "system", "systemversion", new Date(), PlanType.P, PlanStatus.N, new Date(), new Date(), u);
		pr.save(p2);

		Set<Plan> pl = pr.findByStatus(PlanStatus.N);
		pr.findAll();
		
		
	}
}
