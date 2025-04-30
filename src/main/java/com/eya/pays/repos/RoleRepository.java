package com.eya.pays.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.pays.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);

}
