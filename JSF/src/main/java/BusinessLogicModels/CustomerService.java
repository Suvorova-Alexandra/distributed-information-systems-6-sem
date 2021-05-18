package BusinessLogicModels;

import BusinessLogicModels.pojo.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomer(int customerNumber);
    String insertCustomer(Customer customer);
    String updateCustomer(Customer customer);
    String deleteCustomer(Customer customer);
    List<Customer> getCustomers();

}
