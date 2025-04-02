package com.eya.pays.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eya.pays.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays, Long> {

}
