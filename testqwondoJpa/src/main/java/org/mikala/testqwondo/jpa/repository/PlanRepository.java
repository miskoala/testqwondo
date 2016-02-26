package org.mikala.testqwondo.jpa.repository;
import java.util.List;

import org.mikala.testqwondo.jpa.model.Plan;
import org.springframework.data.repository.CrudRepository;
public interface PlanRepository extends CrudRepository<Plan, Long>{
	public List<Plan> findByName(String name);
}
