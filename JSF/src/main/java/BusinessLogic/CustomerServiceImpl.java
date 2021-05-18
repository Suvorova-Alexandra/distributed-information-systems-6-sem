package BusinessLogic;

import BusinessLogicModels.CustomerService;
import BusinessLogicModels.pojo.Customer;
import DataAccess.CustomerRepositoryImpl;
import DataAccessModels.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerRepository repository = CustomerRepositoryImpl.getInstance();

    public CustomerServiceImpl(){}


    @Override
    public Customer findCustomer(int customerNumber) {
        return null;
    }

    @Override
    public String insertCustomer(Customer customer) {
        return repository.insertCustomer(customer);
    }

    @Override
    public String updateCustomer(Customer customer) {
        return repository.updateCustomer(customer);
    }

    @Override
    public String deleteCustomer(Customer customer) {
        return repository.deleteCustomer(customer);
    }


    @Override
    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }
}
