package BusinessLogicModels.pojo;


public class Customer {
    private int customerNumber;
    private String fullName;
    private String phone;
    private double creditLimit;
    public Customer(){}
    public Customer(int customerNumber, String name, String phone, double limit) {
        this.customerNumber=customerNumber;
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

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

}
