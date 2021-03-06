package org.mikala.testqwondo.spring.repository;
import java.util.Set;

import org.mikala.testqwondo.api.model.Plan;
import org.mikala.testqwondo.api.model.enums.PlanStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository("planRepository")
public interface PlanRepository extends PagingAndSortingRepository<Plan, Long>
{
	public Set<Plan> findByName(String name);
	public Set<Plan> findByStatus(PlanStatus planStatus);
}
