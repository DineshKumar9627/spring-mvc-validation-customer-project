package com.sunglowsys.controller;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private  final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private  final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer){
        log.debug("Rest request to create customer: {}",customer);
        return customerService.save(customer);
    }

    @PostMapping("/customers")
    public List<Customer> saveAll(@RequestBody List<Customer> customers){
        log.debug("Rest request to create all customer: {}",customers);
        return customerService.saveAll(customers);
    }

    @GetMapping("/customer/{id}")
    public Customer getById(@PathVariable ("id") Long id){
        log.debug("Test request to find customer by id: {}",id);
        return customerService.findById(id);

    }

    @PutMapping("/customer/{id}")
    public Customer update(@RequestBody Customer customer,@PathVariable ("id") Long id){
        log.debug("Rest request to update customer: {}",id);
        return  customerService.update(customer,id);
    }

    @DeleteMapping("/customer/{id}")
     public  void delete(@PathVariable("id") Long id){
        log.debug("Rest request to  delete customer:  {}",id);
        customerService.delete(id);
     }

     @GetMapping("/customer")
     public List<Customer> getAll(){
        log.debug("Rest request to find all customers :{}");
        List<Customer> customers = customerService.findAll();
        return customers;
     }
}
