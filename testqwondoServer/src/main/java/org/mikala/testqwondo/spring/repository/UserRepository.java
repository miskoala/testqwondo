package org.mikala.testqwondo.spring.repository;
import org.mikala.testqwondo.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{

}
