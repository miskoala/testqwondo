package org.mikala.testqwondo.spring.repository;
import java.util.Set;


import org.mikala.testqwondo.api.model.Plan;
import org.mikala.testqwondo.api.model.PlanStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "plan", path = "plan")
public interface PlanRepository extends CrudRepository<Plan, Long>{
	public Set<Plan> findByName(String name);
	public Set<Plan> findByStatus(PlanStatus planStatus);
}
