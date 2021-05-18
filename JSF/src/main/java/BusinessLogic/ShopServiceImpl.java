package BusinessLogic;

import BusinessLogicModels.ShopService;
import BusinessLogicModels.pojo.Shop;
import DataAccess.ShopRepositoryImpl;
import DataAccessModels.ShopRepository;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static ShopRepository repository = ShopRepositoryImpl.getInstance();

    public ShopServiceImpl(){}

    @Override
    public String insertShop(Shop shop) {
        return repository.insertShop(shop);
    }

    @Override
    public String updateShop(Shop shop) {
        return repository.updateShop(shop);
    }

    @Override
    public String deleteShop(Shop shop) {
        return repository.deleteShop(shop);
    }

    @Override
    public List<Shop> getShops() {
        return repository.getShops();
    }
}
