package com.arancha.solarenergy.controllers;


import com.arancha.solarenergy.entities.Customer;
import com.arancha.solarenergy.entities.Distributor;
import com.arancha.solarenergy.services.CustomerService;
import com.arancha.solarenergy.services.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private DistributorService distributorService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Distributor> distributorList = distributorService.listAll();
        List<Customer> customerList = customerService.listAll();
        model.addAttribute("distributorList", distributorList);
        model.addAttribute("customerList", customerList);
        return "index";
    }
}