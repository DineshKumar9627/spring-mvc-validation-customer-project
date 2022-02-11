package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> saveAll(List<Customer> customers);
    Customer findById(Long id);
    List<Customer> findAll();
    Customer update(Customer customer,Long id);
    void  delete(Long id);

}
