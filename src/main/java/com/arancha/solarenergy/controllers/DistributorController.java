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

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Controller
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Distributor> distributorList = distributorService.listAll();
        model.addAttribute("distributorList", distributorList);
        return "index";
    }

    @RequestMapping("/newDistributor")
    public String showNewDistributor(Model model) {
        Distributor distributor = new Distributor();
        model.addAttribute("distributor", distributor);
        return "new_distributor";
    }

    @RequestMapping(value = "/saveDistributor", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("distributor") Distributor distributor) {
        distributorService.save(distributor);
        return "redirect:/";
    }


    @RequestMapping("/edit/{dssn}")
    public String showEditDistributor(@PathVariable("dssn") Long dssn, Model model) {
        if(dssn != null) {
            Distributor distributor = distributorService.get(dssn);
            model.addAttribute("distributor", distributor);
        } else {
            Distributor distributor = new Distributor();
            model.addAttribute("distributor", distributor);
        }
        return "edit_distributor";

    }

    @RequestMapping("/delete/{dssn}")
    public String deleteProduct(@PathVariable(name = "dssn") Long dssn) {
        distributorService.delete(dssn);
        return "redirect:/";
    }
}
