package com.eya.pays.restcontrollers;
import com.eya.pays.entities.Classification;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eya.pays.dto.PaysDTO;
import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaysRESTController {

    @Autowired
    PaysService paysService;

  

   
    @GetMapping
    public List<PaysDTO> getAllPays() {
        return paysService.getAllPays();
    }

   
    @GetMapping("/{id}")
    public PaysDTO getPaysById(@PathVariable("id") Long id) {
        return paysService.getPays(id);
    }

    
    @RequestMapping(method = RequestMethod.POST)

    public PaysDTO createPays(@RequestBody PaysDTO paysDTO) {
        return paysService.savePays(paysDTO);
    }
    @RequestMapping(method = RequestMethod.PUT)

    public PaysDTO updatePays(@RequestBody PaysDTO paysDTO) {
        return paysService.updatePays(paysDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePays(@PathVariable("id") Long id) {
        paysService.deletePaysById(id);
    }
    @GetMapping("/classifications")
    public List<Classification> getAllClassifications() {
        return paysService.getAllClassifications();
    }
    // Get countries by classification
   
    @GetMapping("/paysclass/{idClass}")
    public List<Pays> getPaysByClassificationId(@PathVariable("idClass") Long idClass) {
        return paysService.findByClassificationIdClass(idClass); // Return List<Pays>
    }
}

