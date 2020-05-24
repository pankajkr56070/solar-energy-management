package com.arancha.solarenergy.controllers;


import com.arancha.solarenergy.entities.Customer;
import com.arancha.solarenergy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/newCustomer")
    public String showNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }


    @RequestMapping("/editCustomer/{cssn}")
    public String showEditCustomer(@PathVariable("cssn") Long cssn, Model model) {
        if (cssn != null) {
            Customer customer = customerService.get(cssn);
            model.addAttribute("customer", customer);
        } else {
            Customer customer = new Customer();
            model.addAttribute("customer", customer);
        }
        return "edit_customer";

    }

    @RequestMapping("/deleteCustomer/{cssn}")
    public String deleteCustomer(@PathVariable(name = "cssn") Long cssn) {
        customerService.delete(cssn);
        return "redirect:/";
    }
}
