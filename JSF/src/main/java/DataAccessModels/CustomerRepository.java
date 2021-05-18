package DataAccessModels;

import BusinessLogicModels.pojo.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerByNumber(int number);
    String insertCustomer(Customer customer);
    String updateCustomer(Customer customer);
    String deleteCustomer(Customer customer);
    List<Customer> getCustomers();
}
