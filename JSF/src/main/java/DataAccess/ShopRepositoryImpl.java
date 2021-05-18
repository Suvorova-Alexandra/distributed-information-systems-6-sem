package DataAccess;

import BusinessLogicModels.pojo.Shop;
import DataAccessModels.ShopRepository;
import DataAccessModels.dbo.ShopEntity;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ShopRepositoryImpl implements ShopRepository {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("customer")
            .createEntityManager();
    private EntityTransaction transactionObj = entityManager.getTransaction();

    private static ShopRepository repository;
    private ShopRepositoryImpl() {
    }

    public static ShopRepository getInstance() {
        if (repository == null) repository = new ShopRepositoryImpl();
        return repository;
    }

    @Override
    public String insertShop(Shop shop) {
        if(!transactionObj.isActive()) {
            transactionObj.begin();
        }
        ShopEntity newObj = new ShopEntity();
        newObj.setIdshop(getMaxId());
        newObj.setShopName(shop.getShopName());
        newObj.setShopType(shop.getShopType());
        newObj.setPhone(shop.getPhone());
        entityManager.persist(newObj);
        transactionObj.commit();
        return "shop.xhtml?faces-redirect=true";
    }

    @Override
    public String updateShop(Shop shop) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        if(isIdPresent(shop.getIdShop())) {
            Query queryObj = entityManager.createQuery("UPDATE ShopEntity s SET s.shopName=:name, s.shopType=:type, " +
                    " s.phone=:phone WHERE s.idshop= :id");
            queryObj.setParameter("id", shop.getIdShop());
            queryObj.setParameter("name", shop.getShopName());
            queryObj.setParameter("phone", shop.getPhone());
            queryObj.setParameter("type", shop.getShopType());
            int updateCount = queryObj.executeUpdate();
            if(updateCount > 0) {
                System.out.println("Record For Id: " + shop.getIdShop() + " Is Updated");
            }
        }
        transactionObj.commit();
        FacesContext.getCurrentInstance().addMessage("editShopForm:id", new FacesMessage("Shop Record #" + shop.getIdShop() + " Is Successfully Updated In Db"));
        return "editShop.xhtml";
    }

    @Override
    public String deleteShop(Shop shop) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        ShopEntity deleteObj = new ShopEntity();
        if(isIdPresent(shop.getIdShop())) {
            deleteObj.setIdshop(shop.getIdShop());
            entityManager.remove(entityManager.merge(deleteObj));
        }
        transactionObj.commit();
        return "shop.xhtml?faces-redirect=true";
    }

    @Override
    public List<Shop> getShops() {
        List<ShopEntity> shopEntities = (List<ShopEntity>)entityManager.createQuery("SELECT c FROM ShopEntity c ").getResultList();
        List<Shop> shops = new ArrayList<>();
        shopEntities.stream().forEach(shop ->{
            shops.add(new Shop(shop.getIdshop(),
                    shop.getShopType(),
                    shop.getShopName(),
                    shop.getPhone()));
            entityManager.refresh(shop);});
        if (shops != null && shops.size() > 0) {
            return shops;
        } else {
            return null;
        }
    }

    private boolean isIdPresent(int shopId) {
        boolean idResult = false;
        Query queryObj = entityManager.createQuery("SELECT s FROM ShopEntity s WHERE s.idshop = :id");
        queryObj.setParameter("id", shopId);
        ShopEntity selectedId = (ShopEntity) queryObj.getSingleResult();
        if(selectedId != null) {
            idResult = true;
        }
        return idResult;
    }

    private int getMaxId() {
        int maxId = 1;
        Query queryObj = entityManager.createQuery("SELECT MAX(s.id)+1 FROM ShopEntity s");
        if(queryObj.getSingleResult() != null) {
            maxId = (Integer) queryObj.getSingleResult();
        }
        return maxId;
    }
}
