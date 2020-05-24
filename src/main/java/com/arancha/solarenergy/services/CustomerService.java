package com.arancha.solarenergy.services;


import com.arancha.solarenergy.entities.Customer;
import com.arancha.solarenergy.entities.Distributor;
import com.arancha.solarenergy.repositories.CustomerRepository;
import com.arancha.solarenergy.repositories.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer get(Long cssn) {
        return customerRepository.findById(cssn).get();
    }


    public void delete(Long cssn) {
        customerRepository.deleteById(cssn);
    }

}
