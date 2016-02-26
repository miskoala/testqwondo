package pl.zetokatowice.testqwondo.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import pl.zetokatowice.testqwondo.jpa.model.Task;
public interface TaskRepository extends CrudRepository<Task, Long>{

}
