package com.rest.lab9.DataAccess.models.repositories;

import com.rest.lab9.DataAccess.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
