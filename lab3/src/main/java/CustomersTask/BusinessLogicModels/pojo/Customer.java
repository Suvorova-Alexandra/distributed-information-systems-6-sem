package CustomersTask.BusinessLogicModels.pojo;

public class Customer {
    private String fullName;
    private String phone;
    private double creditLimit;

    public Customer(String name, String phone,double limit ) {
        this.fullName=name;
        this.phone=phone;
        this.creditLimit=limit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

}
