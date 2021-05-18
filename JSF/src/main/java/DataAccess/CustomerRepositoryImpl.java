package DataAccess;

import BusinessLogicModels.pojo.Customer;
import DataAccessModels.CustomerRepository;
import DataAccessModels.dbo.CustomerEntity;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("customer")
            .createEntityManager();
    private EntityTransaction transactionObj = entityManager.getTransaction();

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
        return entity != null ?
                new Customer(
                        entity.getCustomerNumber(),
                        entity.getFullName(),
                        entity.getPhone(),
                        entity.getCreditLimit()) : null;
    }

    @Override
    public String insertCustomer(Customer customer) {
        if(!transactionObj.isActive()) {
            transactionObj.begin();
        }

        CustomerEntity newObj = new CustomerEntity();
        newObj.setCustomerNumber(getMaxId());
        newObj.setFullName(customer.getFullName());
        newObj.setCreditLimit(customer.getCreditLimit());
        newObj.setPhone(customer.getPhone());
        entityManager.persist(newObj);
        transactionObj.commit();
        return "customer.xhtml?faces-redirect=true";
    }

    @Override
    public String updateCustomer(Customer customer) {

        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        if(isIdPresent(customer.getCustomerNumber())) {
            Query queryObj = entityManager.createQuery("UPDATE CustomerEntity s SET s.fullName=:name, s.creditLimit=:creditLimit, " +
                    " s.phone=:phone WHERE s.customerNumber= :id");
            queryObj.setParameter("id", customer.getCustomerNumber());
            queryObj.setParameter("name", customer.getFullName());
            queryObj.setParameter("phone", customer.getPhone());
            queryObj.setParameter("creditLimit", customer.getCreditLimit());
            int updateCount = queryObj.executeUpdate();
            if(updateCount > 0) {
                System.out.println("Record For Id: " + customer.getCustomerNumber() + " Is Updated");
            }
        }
        transactionObj.commit();
        FacesContext.getCurrentInstance().addMessage("editCustomerForm:id", new FacesMessage("Customer Record #" + customer.getCustomerNumber() + " Is Successfully Updated In Db"));
        return "customerEdit.xhtml";
    }

    @Override
    public String deleteCustomer(Customer customer) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        CustomerEntity deleteObj = new CustomerEntity();
        if(isIdPresent(customer.getCustomerNumber())) {
            deleteObj.setCustomerNumber(customer.getCustomerNumber());
            entityManager.remove(entityManager.merge(deleteObj));
        }
        transactionObj.commit();
        return "customer.xhtml?faces-redirect=true";
    }



    @Override
    public List<Customer> getCustomers() {
        List<CustomerEntity> customerEntities = (List<CustomerEntity>)entityManager.createQuery("SELECT c FROM CustomerEntity c ").getResultList();
        List<Customer> customers = new ArrayList<>();
        customerEntities.stream().forEach(customer ->{
                customers.add(new Customer(customer.getCustomerNumber(),
                        customer.getFullName(),
                        customer.getPhone(),
                        customer.getCreditLimit()));
                entityManager.refresh(customer);
        System.out.println("Name" + customer.getFullName());});
        if (customers != null && customers.size() > 0) {
            return customers;
        } else {
            return null;
        }
    }


    private boolean isIdPresent(int customerId) {
        boolean idResult = false;
        Query queryObj = entityManager.createQuery("SELECT s FROM CustomerEntity s WHERE s.customerNumber = :id");
        queryObj.setParameter("id", customerId);
        CustomerEntity selectedId = (CustomerEntity) queryObj.getSingleResult();
        if(selectedId != null) {
            idResult = true;
        }
        return idResult;
    }

    private int getMaxId() {
        int maxId = 1;
        Query queryObj = entityManager.createQuery("SELECT MAX(s.id)+1 FROM CustomerEntity s");
        if(queryObj.getSingleResult() != null) {
            maxId = (Integer) queryObj.getSingleResult();
        }
        return maxId;
    }
}
