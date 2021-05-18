package com.rest.lab9.DataAccess.models.entities;

import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth")
    private java.sql.Date date_of_birth;

    @Column(name = "passport_series")
    private String passport_series;

    @Column(name = "passport_number")
    private String passport_number;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "employed")
    private Byte employed;

    @Column(name = "position")
    private String position;

    @Column(name = "citisenship")
    private String citisenship;

    @Column(name = "bound_to_military")
    private Byte bound_to_military;

    public Customer() {
    }

    public Customer(Integer id, String lastname, String name, String patronymic, Date date_of_birth, String passport_series, String passport_number, String city, String address, String phone, String email, Byte employed, String position, String citisenship, Byte bound_to_military) {
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

    public Byte isEmployed() {
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

    public Byte isBound_to_military() {
        return bound_to_military;
    }

    public void setBound_to_military(Byte bound_to_military) {
        this.bound_to_military = bound_to_military;
    }
}
