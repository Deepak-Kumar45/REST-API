package com.spring.rest_api2.customer_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest_api2.exception.CustomerNotFoundException;
import com.spring.rest_api2.modal.Customer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class CustomerService {
    
    private List<Customer> customers;
    private static int ctr=105;

    @PostConstruct
    public void init(){
        customers=new ArrayList<>();
        customers.add(new Customer(101, "Rahul verma", "Bulandshahr", false, new Date()));
        customers.add(new Customer(102, "Ruhi verma", "patna", true, new Date()));
        customers.add(new Customer(103, "Deepak kumar", "ghaziabad", false, new Date()));
        customers.add(new Customer(104, "Sandeep sharma", "delhi", true, new Date()));
        customers.add(new Customer(106, "Tinku singh", "noida", false, new Date()));    
    }

    @PreDestroy
    public void destroy(){
        customers.clear();
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public Customer getCustomerById(int id){
        Customer customer=null;
        try {
            customer=customers.stream().filter(i->i.getCustomerId()==id).findFirst().get();
        } catch (Exception e) {
            if(e.getClass().getSimpleName().toString().contains("NoSuchElementException")){
                throw new CustomerNotFoundException(new Date(), e.getMessage(), "Customer not found with "+id+" ID");
            }
        }
        return customer;
    }

}
