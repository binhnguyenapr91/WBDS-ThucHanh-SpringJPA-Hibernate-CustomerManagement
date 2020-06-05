package service.impl;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import repository.CustomerRepository;
import service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class ICustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return customerRepository.save(entity);
    }

    @Override
    public <S extends Customer> Iterable<S> save(Iterable<S> entities) {
        return customerRepository.save(entities);
    }

    @Override
    public Customer findOne(Long aLong) {
        return customerRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return customerRepository.exists(aLong);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Iterable<Customer> findAll(Iterable<Long> longs) {
        return customerRepository.findAll(longs);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long aLong) {
        customerRepository.delete(aLong);
    }

    @Override
    public void delete(Customer entity) {
        customerRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<? extends Customer> entities) {
        customerRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
