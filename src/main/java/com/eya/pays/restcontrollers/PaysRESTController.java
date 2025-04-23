package com.eya.pays.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaysRESTController {
	@Autowired
    PaysService paysService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pays getPaysById(@PathVariable("id") Long id) {
        return paysService.getPays(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Pays createPays(@RequestBody Pays pays) {
        return paysService.savePays(pays);  
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePays(@PathVariable("id") Long id) {
        paysService.deletePaysById(id);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Pays updatePays(@RequestBody Pays pays) {
        return paysService.updatePays(pays);
    }
    @RequestMapping(value = "/paysclass/{idClass}", method = RequestMethod.GET)
    public List<Pays> getPaysByClassificationId(@PathVariable("idClass") Long idClass) {
        return paysService.findByClassificationIdClass(idClass);
    }

}
