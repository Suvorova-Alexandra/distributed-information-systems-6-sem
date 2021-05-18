package CustomersTask.BusinessLogic;

import CustomersTask.BusinessLogicModels.CustomerService;
import CustomersTask.DataAccessModels.CustomerRepository;
import CustomersTask.BusinessLogicModels.pojo.Customer;

import java.util.List;


public class CustomerServiceImpl implements CustomerService {

   private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository=repository;
    }
    @Override
    public Customer findCustomer(int customerNumber) {
        Customer customer=repository.getCustomerByNumber(customerNumber);
       return customer;
    }

    @Override
    public List<Customer> filterCustomersByLimit(double creditLimit) {
        List<Customer> customers=repository.filterCustomersByLimit(creditLimit);
        return customers;
    }

}
