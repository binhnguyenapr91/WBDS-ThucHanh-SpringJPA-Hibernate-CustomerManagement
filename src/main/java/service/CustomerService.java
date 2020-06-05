package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    void save(Customer customer);
    void remove(Long id);
}
