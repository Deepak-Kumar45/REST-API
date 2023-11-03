package com.spring.rest_api2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest_api2.customer_service.CustomerService;
import com.spring.rest_api2.modal.Customer;

@RestController
public class HomeController {

    @Autowired(required = true)
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "Home page";
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer){
        System.out.println("controller:"+customer.getName());
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public String addCustomer(@PathVariable("id") int id){
        // System.out.println("controller:"+customer.getName());
        return "Customer data has been deleted with "+customerService.deleteCustomer(id)+" ID";
    }
}
