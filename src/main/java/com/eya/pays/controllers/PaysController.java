package com.eya.pays.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eya.pays.entities.Classification;
import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;

import jakarta.validation.Valid;

@Controller
public class PaysController {
    @Autowired
    PaysService paysService;

    @RequestMapping("/ListePays")
    public String listePays(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {

          Page<Pays> paysPage = paysService.getAllPaysParPage(page, size);


              modelMap.addAttribute("pays", paysPage);
              modelMap.addAttribute("pages", new int[paysPage.getTotalPages()]);
              modelMap.addAttribute("currentPage", page);
              modelMap.addAttribute("size", size);

              return "listePays"; 
}

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Classification> classes = paysService.getAllClassifications();
    	modelMap.addAttribute("pays", new Pays());
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("classifications", classes);
        return "formPays";
    }
   
    @RequestMapping("/savePays")
    public String saveProduit(@Valid Pays pays,
    	                    BindingResult bindingResult,
    	                    @RequestParam(name = "page", defaultValue = "0") int page,
    	                    @RequestParam(name = "size", defaultValue = "2") int size)
    {
    	int currentPage;
        boolean isNew = false;

        if (bindingResult.hasErrors()) return "formPays";

        if (pays.getIdPays() == null) // ajout
            isNew = true;

        paysService.savePays(pays);

        if (isNew) {
            Page<Pays> paysPage = paysService.getAllPaysParPage(page, size);
            currentPage = paysPage.getTotalPages() - 1; // aller à la dernière page après ajout
        } else {
            currentPage = page; // rester sur la même page après modification
        }

        return "redirect:/ListePays?page=" + currentPage + "&size=" + size;
    }
    
    
    

    @RequestMapping("/modifierPays")
    public String editerPays(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam("page") int page,
            @RequestParam("size") int size) {
    	List<Classification> classes = paysService.getAllClassifications();
        Pays p = paysService.getPays(id);
        modelMap.addAttribute("pays", p);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("classifications", classes);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formPays";
    }

    @RequestMapping("/updatePays")
    public String updatePays(@ModelAttribute("pays") Pays pays,
                             @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateIndep = dateformat.parse(String.valueOf(date));
        pays.setIndependenceDate(dateIndep);

        paysService.updatePays(pays);
        List<Pays> paysList = paysService.getAllPays();
        modelMap.addAttribute("pays", paysList);
        return "listePays";
    }
    @RequestMapping("/supprimerPays")
    public String supprimerPays(@RequestParam("id") Long id,
                                ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size) {
        paysService.deletePaysById(id);
        Page<Pays> paysPage = paysService.getAllPaysParPage(page, size);

        modelMap.addAttribute("pays", paysPage);
        modelMap.addAttribute("pages", new int[paysPage.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listePays";
    }
    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

}
