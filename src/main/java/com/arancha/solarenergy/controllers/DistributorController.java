package com.arancha.solarenergy.controllers;


import com.arancha.solarenergy.entities.Distributor;
import com.arancha.solarenergy.services.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @RequestMapping("/newDistributor")
    public String showNewDistributor(Model model) {
        Distributor distributor = new Distributor();
        model.addAttribute("distributor", distributor);
        return "new_distributor";
    }

    @RequestMapping(value = "/saveDistributor", method = RequestMethod.POST)
    public String saveDistributor(@ModelAttribute("distributor") Distributor distributor) {
        distributorService.save(distributor);
        return "redirect:/";
    }


    @RequestMapping("/editDistributor/{dssn}")
    public String showEditDistributor(@PathVariable("dssn") Long dssn, Model model) {
        if (dssn != null) {
            Distributor distributor = distributorService.get(dssn);
            model.addAttribute("distributor", distributor);
        } else {
            Distributor distributor = new Distributor();
            model.addAttribute("distributor", distributor);
        }
        return "edit_distributor";

    }

    @RequestMapping("/deleteDistributor/{dssn}")
    public String deleteDistributor(@PathVariable(name = "dssn") Long dssn) {
        distributorService.delete(dssn);
        return "redirect:/";
    }
}
