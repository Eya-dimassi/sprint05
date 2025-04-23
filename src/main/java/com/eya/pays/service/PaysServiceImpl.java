package com.eya.pays.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
import com.eya.pays.repos.ClassificationRepository;
import com.eya.pays.repos.PaysRepository;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    PaysRepository paysRepository;
    

    @Override
    public Pays savePays(Pays p) {
        return paysRepository.save(p);
    }

    @Override
    public Pays updatePays(Pays p) {
        return paysRepository.save(p);
    }

    @Override
    public void deletePays(Pays p) {
        paysRepository.delete(p);
    }

    @Override
    public void deletePaysById(Long id) {
        paysRepository.deleteById(id);
    }

    @Override
    public Pays getPays(Long id) {
        return paysRepository.findById(id).get();
    }

    @Override
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }
    @Override
    public Page<Pays> getAllPaysParPage(int page, int size) {
        return paysRepository.findAll(PageRequest.of(page, size));
    }
    @Override
    public List<Pays> findByNomPays(String nom) {
        return paysRepository.findByNomPays(nom);
    }

    @Override
    public List<Pays> findByNomPaysContains(String nom) {
        return paysRepository.findByNomPaysContains(nom);
    }

    @Override
    public List<Pays> findByClassification(Classification classification) {
        return paysRepository.findByClassification(classification);
    }

    @Override
    public List<Pays> findByClassificationIdClass(Long id) {
        return paysRepository.findByClassificationIdClass(id);
    }

    @Override
    public List<Pays> findByOrderByNomPaysAsc() {
        return paysRepository.findByOrderByNomPaysAsc();
    }

    @Override
    public List<Pays> trierPaysNomsClassifications() {
        return paysRepository.trierPaysNomsClassifications();
    }
    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public List<Classification> getAllClassifications() {
        return classificationRepository.findAll();
    }

}

