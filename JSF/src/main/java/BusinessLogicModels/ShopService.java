package BusinessLogicModels;

import BusinessLogicModels.pojo.Shop;

import java.util.List;

public interface ShopService {

    String insertShop(Shop shop);
    String updateShop(Shop shop);
    String deleteShop(Shop shop);
    List<Shop> getShops();
}
