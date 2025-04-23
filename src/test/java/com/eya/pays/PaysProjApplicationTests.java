package com.eya.pays;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
import com.eya.pays.repos.PaysRepository;
import com.eya.pays.service.PaysService;

@SpringBootTest
class PaysProjApplicationTests {

    @Autowired
    private PaysRepository paysRepository;
    @Autowired
    private PaysService paysService;

    // **Test to Create a New Pays Record**
    @Test
    public void testCreatePays() {
        Pays pays = new Pays("Tunisia", 12000000L, "Africa", new Date());
        paysRepository.save(pays);
    }

    // **Test to Find a Pays by ID**
    @Test
    public void testFindPays() {
        Pays p = paysRepository.findById(2L).orElse(null);
        System.out.println(p);
    }

    // **Test to Update a Pays Record**
    @Test
    public void testUpdatePays() {
        Pays p = paysRepository.findById(2L).orElse(null);
        if (p != null) {
            p.setPopulation(13000000L); // Update population
            paysRepository.save(p);
        }
    }

    // **Test to Delete a Pays Record**
    @Test
    public void testDeletePays() {
        paysRepository.deleteById(2L);
    }

    // **Test to List All Pays Records**
    @Test
    public void testListerTousPays() {
        List<Pays> paysList = paysRepository.findAll();
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    
    @Test
    public void testFindByNomPays() {
        List<Pays> paysList = paysRepository.findByNomPays("Tunisie");
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByNomPaysContains() {
        List<Pays> paysList = paysRepository.findByNomPaysContains("Tuni");
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByNomEtPop() {
        List<Pays> paysList = paysRepository.findByNomEtPop("a", 10000000L);
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByClassification() {
        Classification c = new Classification();
        c.setIdClass(1L); 

        List<Pays> paysList = paysRepository.findByClassification(c);
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByClassificationIdClass() {
        List<Pays> paysList = paysRepository.findByClassificationIdClass(1L);
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testFindByOrderByNomPaysAsc() {
        List<Pays> paysList = paysRepository.findByOrderByNomPaysAsc();
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }
    @Test
    public void testTrierPaysNomsClassifications() {
        List<Pays> paysList = paysRepository.trierPaysNomsClassifications();
        for (Pays p : paysList) {
            System.out.println(p);
        }
    }



}
