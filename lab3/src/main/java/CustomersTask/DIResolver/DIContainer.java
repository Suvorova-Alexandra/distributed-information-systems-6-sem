package CustomersTask.DIResolver;

import CustomersTask.BusinessLogic.CustomerServiceImpl;
import CustomersTask.BusinessLogicModels.CustomerService;
import CustomersTask.DataAccess.CustomerRepositoryImpl;

public class DIContainer {
    private static DIContainer container;

    private DIContainer() {
    }

    public static DIContainer getInstance() {
        if (container == null) container = new DIContainer();
        return container;
    }

    public CustomerService createCustomerController(){
        return new CustomerServiceImpl(CustomerRepositoryImpl.getInstance());
    }
}
