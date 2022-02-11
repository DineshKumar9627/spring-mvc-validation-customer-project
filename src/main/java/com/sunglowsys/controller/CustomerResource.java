package com.sunglowsys.controller;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PostMapping("/customers")
    public List<Customer> saveAll(@RequestBody List<Customer> customers){
        return customerService.saveAll(customers);
    }

    @GetMapping("/customer/{id}")
    public Customer getById(@PathVariable ("id") Long id){
        return customerService.findById(id);

    }

    @PutMapping("/customer/{id}")
    public Customer update(@RequestBody Customer customer,@PathVariable ("id") Long id){
        return  customerService.update(customer,id);
    }

    @DeleteMapping("/customer/{id}")
     public  void delete(@PathVariable("id") Long id){
        customerService.delete(id);
     }

     @GetMapping("/customer")
     public List<Customer> getAll(){
        List<Customer> customers = customerService.findAll();
        return customers;
     }
}
