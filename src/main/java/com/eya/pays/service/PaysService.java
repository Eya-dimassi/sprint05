package com.eya.pays.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.pays.dto.PaysDTO;
import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
public interface PaysService {
	
    PaysDTO getPays(Long id);
    List<PaysDTO> getAllPays();
    
    PaysDTO savePays(PaysDTO p);
    PaysDTO updatePays(PaysDTO p);
    
 
    Pays updatePays(Pays p);
    void deletePays(Pays p);
    void deletePaysById(Long id);
   
    Page<Pays> getAllPaysParPage(int page, int size);
    List<Pays> findByNomPays(String nom);
    List<Pays> findByNomPaysContains(String nom);
    List<Pays> findByClassification(Classification classification);
    List<Pays> findByClassificationIdClass(Long id);
    List<Pays> findByOrderByNomPaysAsc();
    List<Pays> trierPaysNomsClassifications();
    List<Classification> getAllClassifications();
    PaysDTO convertEntityToDto(Pays pays);
    Pays convertDtoToEntity(PaysDTO paysDTO);

    
}

