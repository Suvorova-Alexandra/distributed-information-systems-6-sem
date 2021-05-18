package CustomersTask.DataAccess;

import CustomersTask.DataAccessModels.CustomerRepository;
import CustomersTask.DataAccessModels.dbo.CustomerEntity;
import CustomersTask.BusinessLogicModels.pojo.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("customer")
            .createEntityManager();

    private static CustomerRepository repository;

    private CustomerRepositoryImpl() {
    }

    public static CustomerRepository getInstance() {
        if (repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    @Override
    public Customer getCustomerByNumber(int number) {
        CustomerEntity entity = entityManager.find(CustomerEntity.class, number);
        return entity != null ? new Customer(entity.getFullName(), entity.getPhone(), entity.getCreditLimit()) : null;
    }

    @Override
    public List<Customer> filterCustomersByLimit(double creditLimit) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("databasename.filterByCreditLimit");
       query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
       query.setParameter(1, creditLimit);
       query.execute();
         List<Object[]> results = (List<Object[]>)query.getResultList();
        List<Customer> customers = new ArrayList<>();
          results.stream().forEach(customer ->
                customers.add(new Customer((String)customer[2], (String)customer[1], (Float)customer[0])));

        /*Query queryProcedure = entityManager.createNativeQuery("{call filterByCreditLimit(?)}",CustomerEntity.class);
        queryProcedure.setParameter(1, creditLimit);
        List<CustomerEntity> results = (List<CustomerEntity>) queryProcedure.getResultList();

        results.stream().forEach(customer ->
                customers.add(new Customer(customer.getFullName(), customer.getPhone(), customer.getCreditLimit())));*/

        return customers;
    }

}
