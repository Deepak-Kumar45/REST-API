package com.spring.rest_api2.modal;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private int customerId;    
    private String name;
    private String address;
    public int getCustomerId() {
        return customerId;
    }
   
    public Customer() {
    }
    public Customer(int customerId, String name, String address, boolean coupon, Date lastmodified) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.coupon = coupon;
        this.lastmodified = lastmodified;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isCoupon() {
        return coupon;
    }
    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }
    public Date getLastmodified() {
        return lastmodified;
    }
    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }
    private boolean coupon;
    private Date lastmodified;
    
}
