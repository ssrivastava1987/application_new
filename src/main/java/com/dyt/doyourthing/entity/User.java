package com.dyt.doyourthing.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "EMAIL")
    private String email;
    @OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
    private Address address;
    @Column(name = "PHONE")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
