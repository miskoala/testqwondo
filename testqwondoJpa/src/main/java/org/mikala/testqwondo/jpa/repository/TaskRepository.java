package org.mikala.testqwondo.jpa.repository;
import org.mikala.testqwondo.jpa.model.Task;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepository extends CrudRepository<Task, Long>{

}
