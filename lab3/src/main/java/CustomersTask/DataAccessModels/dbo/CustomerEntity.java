package CustomersTask.DataAccessModels.dbo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "databasename")
@SqlResultSetMapping(name = "CustomerEntity",
        entities={
                @EntityResult(entityClass=CustomerEntity.class, fields={
                        @FieldResult(name="fullName", column="fullName"),
                        @FieldResult(name="phone", column="phone"),
                        @FieldResult(name="creditLimit", column="creditLimit")})},
        columns={
                @ColumnResult(name="item_name")} )
public class CustomerEntity {
    private int customerNumber;
    private String zip;
    private String email;
    private String fullName;
    private String phone;
    private String city;
    private Integer stateCode;
    private Double creditLimit;

    public CustomerEntity() {
    }

    public CustomerEntity(Double creditLimit, String phone, String fullName) {
        this.creditLimit = creditLimit;
        this.phone = phone;
        this.fullName = fullName;
    }

    @Id
    @Column(name = "customerNumber", nullable = false)
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Basic
    @Column(name = "zip", nullable = true, length = 45)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fullName", nullable = false, length = 45)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "stateCode", nullable = true)
    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    @Basic
    @Column(name = "creditLimit", nullable = true, precision = 0)
    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerNumber != that.customerNumber) return false;
        if (!Objects.equals(zip, that.zip)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(stateCode, that.stateCode)) return false;
        if (!Objects.equals(creditLimit, that.creditLimit)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerNumber;
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        return result;
    }
}
