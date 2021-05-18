package com.rest.lab9.BusinessLogic;

import com.rest.lab9.BusinessLogic.models.CustomerService;
import com.rest.lab9.BusinessLogic.models.dto.CustomerDTO;
import com.rest.lab9.BusinessLogic.models.mappers.CustomerMapper;
import com.rest.lab9.DataAccess.models.entities.Customer;
import com.rest.lab9.DataAccess.models.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper mapper;

    @Override
    public CustomerDTO getById(Integer id) {
        return !customerRepository.findById(id).isEmpty() ? mapper.toDTO(customerRepository.findById(id).get()) : null;
    }

    @Override
    public boolean save(CustomerDTO customer) {

        if(validatePhoneNumber(customer.getPhone()) && validatePassportNumber(customer.getPassport_number())) {
            customerRepository.save(mapper.toEntity(customer));
            return true;
        }
        else return false;
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customers=new ArrayList<>();
        for(Customer customer : customerRepository.findAll()){
            customers.add(mapper.toDTO(customer));
        }
        return !customers.isEmpty() ? customers : null;
    }

    private boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;

    }

    private boolean validatePassportNumber(String passport) {

        if (passport.matches("\\d{7}")) return true;
        else return false;

    }
}
