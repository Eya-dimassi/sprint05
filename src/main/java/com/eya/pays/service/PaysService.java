package com.eya.pays.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.pays.entities.Pays;
public interface PaysService {
    Pays savePays(Pays p);
    Pays updatePays(Pays p);
    void deletePays(Pays p);
    void deletePaysById(Long id);
    Pays getPays(Long id);
    List<Pays> getAllPays();
    Page<Pays> getAllPaysParPage(int page, int size);
}

