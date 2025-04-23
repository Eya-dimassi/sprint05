package com.eya.pays.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.pays.entities.Classification;
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
	

}
