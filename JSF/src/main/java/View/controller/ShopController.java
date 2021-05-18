package View.controller;

import BusinessLogicModels.ShopService;
import BusinessLogicModels.pojo.Shop;
import di.Container;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ShopController implements Serializable {
    private Shop newShop;
    private Shop shopForUpdate;
    private ShopService service = Container.getInstance().createShopService();

    @PostConstruct
    public void init() {
        this.newShop = new Shop();
        this.shopForUpdate=new Shop();
    }


    public void setNewShop(Shop shop) {
        this.newShop = shop;
    }

    public Shop getNewShop() {
        return this.newShop;
    }

    public Shop getShopForUpdate() {

        return shopForUpdate;
    }

    public void setShopForUpdate(Shop shopForUpdate) {
        this.shopForUpdate = shopForUpdate;
    }

    public List getAllShops() {
        this.newShop = new Shop();
        return service.getShops();
    }

    public String insert() {
        return service.insertShop(newShop);
    }
    public String deleteShop(Shop shop) {
        return service.deleteShop(shop);
    }


    public String editShop() {
        shopForUpdate.setIdShop(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id")));
        shopForUpdate.setShopName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("name"));
        shopForUpdate.setPhone(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("phone"));
        shopForUpdate.setShopType(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("type"));
        return "editShop.xhtml";
    }


    public String updateShop(Shop shop) {
        return service.updateShop(shop);
    }

}
