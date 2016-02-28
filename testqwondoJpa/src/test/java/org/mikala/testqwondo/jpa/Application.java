package org.mikala.testqwondo.jpa;

import java.util.Date;

import org.mikala.testqwondo.api.model.Plan;
import org.mikala.testqwondo.api.model.PlanType;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.jpa.repository.PlanRepository;
import org.mikala.testqwondo.jpa.repository.UserRepository;
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
	public CommandLineRunner demo(PlanRepository repository,UserRepository ur) {
		return (args) -> {
			User u = new User("admin", "password", "name", "email", "jabber");
			ur.save(u);
			Plan p= new Plan("name", "system", "systemVersion", new Date(), PlanType.P, "status", new Date(), new Date(),u);
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
            log.info("");
		};
	}

}