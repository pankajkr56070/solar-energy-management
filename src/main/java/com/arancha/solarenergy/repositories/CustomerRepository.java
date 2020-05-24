package com.arancha.solarenergy.repositories;

import com.arancha.solarenergy.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
