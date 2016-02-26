package pl.zetokatowice.testqwondo.jpa.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.zetokatowice.testqwondo.jpa.model.Plan;
public interface PlanRepository extends CrudRepository<Plan, Long>{
	public List<Plan> findByName(String name);
}
