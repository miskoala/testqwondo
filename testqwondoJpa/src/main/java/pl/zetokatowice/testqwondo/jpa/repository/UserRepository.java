package pl.zetokatowice.testqwondo.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import pl.zetokatowice.testqwondo.jpa.model.User;
public interface UserRepository extends CrudRepository<User, Long>{

}
