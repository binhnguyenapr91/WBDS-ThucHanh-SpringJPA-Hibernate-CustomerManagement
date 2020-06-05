package service.impl;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;

public class ICustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
