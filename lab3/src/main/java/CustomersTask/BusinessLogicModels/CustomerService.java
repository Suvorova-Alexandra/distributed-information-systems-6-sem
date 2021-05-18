package CustomersTask.BusinessLogicModels;

import CustomersTask.BusinessLogicModels.pojo.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomer(int customerNumber);
    List<Customer> filterCustomersByLimit(double creditLimit);

}
