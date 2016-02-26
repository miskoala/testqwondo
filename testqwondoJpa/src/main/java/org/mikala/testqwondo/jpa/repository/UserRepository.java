package org.mikala.testqwondo.jpa.repository;
import org.mikala.testqwondo.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Long>{

}
