package org.mikala.testqwondo.web.tests;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.api.model.enums.Role;
import org.mikala.testqwondo.spring.repository.UserRepository;
import org.mikala.testqwondo.spring.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(//PlanRepository repository,
			UserRepository ur, UserRoleRepository urr) {
		return (args) -> {
			for (int i = 0; i < 20; i++) {
				User u = new User("login"+i, "password"+i, "name"+i, "email"+i, "jabber"+i);
				u=ur.save(u);
				UserRole userRoleAdmin= new UserRole(u, Role.ADMIN);
				userRoleAdmin=urr.save(userRoleAdmin);
				UserRole userRoleMan= new UserRole(u, Role.TEST_MANAGER);
				userRoleMan=urr.save(userRoleMan);
				UserRole userRoleTes= new UserRole(u, Role.TESTER);
				userRoleTes=urr.save(userRoleTes);
			}
/*			Plan p= new Plan("name", "system", "systemVersion", new Date(), PlanType.P, PlanStatus.N, new Date(), new Date(),u);
			repository.save(p);


			for (Plan plan : repository.findAll()) {
				log.info(plan.toString());
			}
            log.info("");

			Plan plan = repository.findOne(1L);
			log.info("--------------------------------");
			log.info(plan.toString());
            log.info("");



			log.info("--------------------------------------------");
			for (Plan plan1 : repository.findByName("name")) {
				log.info(plan1.toString());
			}
            log.info("");*/
		};
	}

}