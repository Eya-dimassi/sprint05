package com.eya.pays.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eya.pays.entities.Pays;
import com.eya.pays.service.PaysService;

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

              return "listePays"; 
}

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createPays";
    }

    @RequestMapping("/savePays")
    public String savePays(@ModelAttribute("pays") Pays pays,
                           @RequestParam("date") String date,
                           ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateIndep = dateformat.parse(String.valueOf(date));
        pays.setIndependenceDate(dateIndep);

        Pays savePays = paysService.savePays(pays);
        String msg = "Pays enregistré avec Id " + savePays.getIdPays();
        modelMap.addAttribute("msg", msg);
        return "createPays";
    }

    

    @RequestMapping("/modifierPays")
    public String editerPays(@RequestParam("id") Long id, ModelMap modelMap) {
        Pays p = paysService.getPays(id);
        modelMap.addAttribute("pays", p);
        return "editerPays";
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

}
