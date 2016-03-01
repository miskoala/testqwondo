package org.mikala.testqwondo.jpa.repository;
import java.util.Set;

import org.mikala.testqwondo.api.model.Plan;
import org.mikala.testqwondo.api.model.PlanStatus;
import org.springframework.data.repository.CrudRepository;
public interface PlanRepository extends CrudRepository<Plan, Long>{
	public Set<Plan> findByName(String name);
	public Set<Plan> findByStatus(PlanStatus planStatus);
}
