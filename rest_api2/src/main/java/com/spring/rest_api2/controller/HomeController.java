package com.spring.rest_api2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest_api2.customer_service.CustomerService;
import com.spring.rest_api2.modal.Customer;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class HomeController {

    @Autowired(required = true)
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "Home page";
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id){
        Customer customer=customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        System.out.println("controller:"+customer.getName());
        return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
        // System.out.println("controller:"+customer.getName());
        return ResponseEntity.ok("Customer data has been deleted with "+customerService.deleteCustomer(id)+" ID");
    }

    @PutMapping(value="/customer/{id}")
    public ResponseEntity<Customer> editCustomerDetails(@PathVariable("id") int id, @RequestBody Customer entity) {
       Customer c=customerService.updateData(id, entity);
       return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }
}
