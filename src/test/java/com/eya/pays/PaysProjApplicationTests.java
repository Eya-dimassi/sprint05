package com.eya.pays;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.eya.pays.entities.Pays;
import com.eya.pays.repos.PaysRepository;

@SpringBootTest
class PaysProjApplicationTests {

    @Autowired
    private PaysRepository paysRepository;

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
}
