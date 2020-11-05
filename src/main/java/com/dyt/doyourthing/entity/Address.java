package com.dyt.doyourthing.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private User user;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIP_CODE")
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
