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

  

   
    @RequestMapping(path="all",method = RequestMethod.GET)
    public List<PaysDTO> getAllPays() {
        return paysService.getAllPays();
    }

   
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public PaysDTO getPaysById(@PathVariable("id") Long id) {
        return paysService.getPays(id);
    }

    
    
    @RequestMapping(path="/addpays",method = RequestMethod.POST)
    public PaysDTO createPays(@RequestBody PaysDTO paysDTO) {
        return paysService.savePays(paysDTO);
    }
    
    @RequestMapping(path="/updatepays",method = RequestMethod.PUT)
    public PaysDTO updatePays(@RequestBody PaysDTO paysDTO) {
        return paysService.updatePays(paysDTO);
    }

    @RequestMapping(value="/delpays/{id}",method = RequestMethod.DELETE)
    public void deletePays(@PathVariable("id") Long id) {
        paysService.deletePaysById(id);
    }
   
   
    @RequestMapping(value="/paysclass/{idClass}",method = RequestMethod.GET)
    public List<Pays> getPaysByClassificationId(@PathVariable("idClass") Long idClass) {
        return paysService.findByClassificationIdClass(idClass); 
    }
}

