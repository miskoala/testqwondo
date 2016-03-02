package org.mikala.testqwondo.spring.repository;
import org.mikala.testqwondo.api.model.UserRole;
import org.mikala.testqwondo.api.model.UserRoleId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleId>{

}
