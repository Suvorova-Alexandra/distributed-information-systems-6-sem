package com.rest.lab9.BusinessLogic.models;

import com.rest.lab9.BusinessLogic.models.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getById(Integer id);

    boolean save(CustomerDTO customer);

    void delete(Integer id);

    List<CustomerDTO> getAll();

}
