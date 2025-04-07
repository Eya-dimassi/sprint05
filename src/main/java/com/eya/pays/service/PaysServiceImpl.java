package com.eya.pays.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.eya.pays.entities.Pays;
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

}

