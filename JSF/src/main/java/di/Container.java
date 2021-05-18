package di;

import BusinessLogic.CustomerServiceImpl;
import BusinessLogic.ShopServiceImpl;
import BusinessLogicModels.CustomerService;
import BusinessLogicModels.ShopService;

public class Container {
    private static Container container;
    private Container() {
    }

    public static Container getInstance() {
        if (container == null) container = new Container();
        return container;
    }

    public CustomerService createCustomerService(){
        return new CustomerServiceImpl();
    }

    public ShopService createShopService(){
        return new ShopServiceImpl();
    }
}