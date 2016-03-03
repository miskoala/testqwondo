package org.mikala.testqwondo.spring.repository;
import org.mikala.testqwondo.api.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	Page<User> findByNameLikeIgnoreCase(String name, Pageable pageable);

}
