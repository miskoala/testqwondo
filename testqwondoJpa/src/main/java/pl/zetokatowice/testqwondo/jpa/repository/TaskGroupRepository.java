package pl.zetokatowice.testqwondo.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import pl.zetokatowice.testqwondo.jpa.model.TaskGroup;
public interface TaskGroupRepository extends CrudRepository<TaskGroup, Long>{

}
