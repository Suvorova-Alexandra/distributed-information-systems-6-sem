package CustomersTask.DataAccessModels;

import CustomersTask.BusinessLogicModels.pojo.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerByNumber(int number);
    List<Customer> filterCustomersByLimit(double creditLimit);
}
