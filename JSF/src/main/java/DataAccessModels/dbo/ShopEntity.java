package DataAccessModels.dbo;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class ShopEntity {
    @Id
    @Column(name = "idshop")
    private Integer idshop;

    @Column(name = "shopName")
    private String shopName;

    @Column(name = "shopType")
    private String shopType;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "website")
    private String website;

    @Column(name = "phone")
    private String phone;

    public Integer getIdshop() {
        return this.idshop;
    }

    public void setIdshop(Integer idshop) {
        this.idshop = idshop;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return this.shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
