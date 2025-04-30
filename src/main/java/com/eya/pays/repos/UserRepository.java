package com.eya.pays.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.pays.entities.User;
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername (String username);

	

}
