package com.eya.pays.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eya.pays.entities.Classification;
@RepositoryRestResource(path = "class")
@CrossOrigin("http://localhost:4200/") 
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
	

}
