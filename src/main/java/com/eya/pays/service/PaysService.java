package com.eya.pays.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.pays.dto.PaysDTO;
import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
public interface PaysService {
   // Pays savePays(Pays p);
    Pays updatePays(Pays p);
    void deletePays(Pays p);
    void deletePaysById(Long id);
   // Pays getPays(Long id);
   // List<Pays> getAllPays();
    Page<Pays> getAllPaysParPage(int page, int size);
   // List<Pays> getAllPays();
    List<Pays> findByNomPays(String nom);
    List<Pays> findByNomPaysContains(String nom);
    List<Pays> findByClassification(Classification classification);
    List<Pays> findByClassificationIdClass(Long id);
    List<Pays> findByOrderByNomPaysAsc();
    List<Pays> trierPaysNomsClassifications();
    List<Classification> getAllClassifications();
    PaysDTO convertEntityToDto(Pays pays);
    PaysDTO savePays(Pays p);
    PaysDTO getPays(Long id);
    List<PaysDTO> getAllPays();
}

