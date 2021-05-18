package com.rest.lab9.BusinessLogic.models.mappers;


import com.rest.lab9.BusinessLogic.models.dto.CustomerDTO;
import com.rest.lab9.DataAccess.models.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getLastname(),
                customer.getName(),
                customer.getPatronymic(),
                customer.getDate_of_birth(),
                customer.getPassport_series(),
                customer.getPassport_number(),
                customer.getCity(), customer.getAddress(),
                customer.getPhone(),
                customer.getEmail(),
                customer.isEmployed(),
                customer.getPosition(),
                customer.getCitisenship(),
                customer.isBound_to_military());
    }

    public Customer toEntity(CustomerDTO customer) {
        return new Customer(
                customer.getId(),
                customer.getLastname(),
                customer.getName(),
                customer.getPatronymic(),
                customer.getDate_of_birth(),
                customer.getPassport_series(),
                customer.getPassport_number(),
                customer.getCity(), customer.getAddress(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getEmployed(),
                customer.getPosition(),
                customer.getCitisenship(),
                customer.getBound_to_military());
    }
}
