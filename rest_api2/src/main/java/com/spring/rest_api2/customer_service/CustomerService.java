package com.spring.rest_api2.customer_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.spring.rest_api2.exception.CustomerAlreadyExistsException;
import com.spring.rest_api2.exception.CustomerNotFoundException;
import com.spring.rest_api2.modal.Customer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class CustomerService {
    
    private List<Customer> customers;
    private static int ctr=106;

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
                throw new CustomerNotFoundException(new Date(), e.getMessage(), ""+id);
            }
        }
        return customer;
    }


    public Customer addCustomer(Customer customer){
        Customer c=null;
        try {
            c=customers.stream().filter(i->i.getName().equals(customer.getName())).findFirst().get();
        } catch (Exception e) {
            if(e.getClass().getSimpleName().toString().contains("NoSuchElementException")){
                ++ctr;
                customer.setCustomerId(ctr);
                customer.setLastmodified(new Date());
                customers.add(customer);
                c=customer;
                return customer;
            }else{

            }
        }
        if(c!=null){
            throw new CustomerAlreadyExistsException("Customer is already present with '"+customer.getName()+"' name. Please enter another name..");
        }
        return c;
    }

    public int deleteCustomer(int customerId){
        Customer c=getCustomerById(customerId);
        customers.remove(c);
        return c.getCustomerId();
    }
    
}
