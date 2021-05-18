package com.rest.lab9.BusinessLogic.models.dto;

import java.sql.Date;


public class CustomerDTO {
    private Integer id;
    private String lastname;
    private String name;
    private String patronymic;
    private java.sql.Date date_of_birth;
    private String passport_series;
    private String passport_number;
    private String city;
    private String address;
    private String phone;
    private String email;
    private Byte employed;
    private String position;
    private String citisenship;
    private Byte bound_to_military;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String lastname, String name, String patronymic, Date date_of_birth, String passport_series, String passport_number, String city, String address, String phone, String email, Byte employed, String position, String citisenship, Byte bound_to_military) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.passport_series = passport_series;
        this.passport_number = passport_number;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.employed = employed;
        this.position = position;
        this.citisenship = citisenship;
        this.bound_to_military = bound_to_military;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getEmployed() {
        return employed;
    }

    public void setEmployed(Byte employed) {
        this.employed = employed;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCitisenship() {
        return citisenship;
    }

    public void setCitisenship(String citisenship) {
        this.citisenship = citisenship;
    }

    public Byte getBound_to_military() {
        return bound_to_military;
    }

    public void setBound_to_military(Byte bound_to_military) {
        this.bound_to_military = bound_to_military;
    }
}
