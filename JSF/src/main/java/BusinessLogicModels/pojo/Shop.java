package BusinessLogicModels.pojo;

public class Shop {
    private int idshop;
    private String shopType;
    private String shopName;
    private String phone;

    public Shop() {
    }

    public Shop(int idshop, String shopType, String shopName, String phone) {
        this.idshop = idshop;
        this.shopType = shopType;
        this.shopName = shopName;
        this.phone = phone;
    }

    public int getIdShop() {
        return idshop;
    }

    public void setIdShop(int idshop) {
        this.idshop = idshop;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
