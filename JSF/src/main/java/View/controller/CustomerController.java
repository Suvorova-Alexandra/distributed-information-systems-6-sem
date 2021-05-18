package View.controller;

import BusinessLogicModels.CustomerService;
import BusinessLogicModels.pojo.Customer;
import di.Container;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CustomerController implements Serializable {
    private Customer newCustomer;
    private Customer customerForUpdate;
    private CustomerService service =Container.getInstance().createCustomerService();

    @PostConstruct
    public void init() {
        this.newCustomer = new Customer();
        this.customerForUpdate=new Customer();
    }


    public void setNewCustomer(Customer customer) {
        this.newCustomer = customer;
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public Customer getCustomerForUpdate() {
        return customerForUpdate;
    }

    public void setCustomerForUpdate(Customer customerForUpdate) {
        this.customerForUpdate = customerForUpdate;
    }

    public List getAllCustomers() {

        return service.getCustomers();
    }

    public String insert() {
        return service.insertCustomer(newCustomer);
    }
    public String deleteCustomer(Customer customer) {
        return service.deleteCustomer(customer);
    }


    public String editCustomer() {
        customerForUpdate.setCustomerNumber(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerId")));
        customerForUpdate.setFullName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerName"));
        customerForUpdate.setPhone(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerPhone"));
        customerForUpdate.setCreditLimit(Double.parseDouble(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerCredit")));
        return "customerEdit.xhtml";
    }


    public String updateCustomer(Customer customer) {
        return service.updateCustomer(customer);
    }

}
