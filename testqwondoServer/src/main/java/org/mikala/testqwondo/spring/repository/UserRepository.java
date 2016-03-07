package org.mikala.testqwondo.spring.repository;
import org.mikala.testqwondo.api.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	@Query(value="select u from User u where lower(u.name) like  lower(CONCAT('%',:name, '%'))")
	Page<User> findByNameLike(@Param("name") String name, Pageable pageable);
	
	@Query(value="select u from User u where lower(u.name) like  lower(CONCAT('%',(:name) , '%')) and lower(u.login) like  lower(CONCAT('%',:login, '%'))")
	Page<User> findByNameAndLoginLike(@Param("name") String name, @Param("login") String login, Pageable pageable);
	
	User findByName(String name);
	User findByLogin(String login);
}