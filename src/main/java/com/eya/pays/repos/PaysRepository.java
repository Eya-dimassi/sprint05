package com.eya.pays.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
@RepositoryRestResource(path = "rest")
public interface PaysRepository extends JpaRepository<Pays, Long> {
	List<Pays> findByNomPays(String nom);
    List<Pays> findByNomPaysContains(String nom);
    @Query("select p from Pays p where p.nomPays like %:nom% and p.population > :pop")
    List<Pays> findByNomEtPop(@Param("nom") String nom, @Param("pop") Long population);
    @Query("select p from Pays p where p.classification = ?1")
    List<Pays> findByClassification(Classification classification);
    @Query("select p from Pays p where p.classification.nomClass = ?1")
    List<Pays> findByNomClassification(String nom);
    @Query("select p from Pays p where p.classification.idClass = ?1")
    List<Pays> findByClassificationIdClass(Long id);
    List<Pays> findByOrderByNomPaysAsc();
    @Query("select p from Pays p order by p.nomPays ASC, p.classification.nomClass DESC")
    List<Pays> trierPaysNomsClassifications();


}
