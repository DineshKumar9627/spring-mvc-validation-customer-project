package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer  customer = null;
        if(optional.isPresent()){
            customer = optional.get();
        }
        else {
            throw new RuntimeException("customer not found for this id");
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer, Long id) {
        Customer customer1 = customerRepository.getById(id);
        customer1.setLastName(customer.getLastName());
        return customerRepository.save(customer1);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
