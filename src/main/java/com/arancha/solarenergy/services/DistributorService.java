package com.arancha.solarenergy.services;


import com.arancha.solarenergy.entities.Distributor;
import com.arancha.solarenergy.repositories.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    public List<Distributor> listAll() {
        return distributorRepository.findAll();
    }

    public void save(Distributor distributor) {
        distributorRepository.saveAndFlush(distributor);
    }

    public Distributor get(Long dssn) {
        return distributorRepository.findById(dssn).get();
    }


    public void delete(Long dssn) {
        distributorRepository.deleteById(dssn);
    }

}
