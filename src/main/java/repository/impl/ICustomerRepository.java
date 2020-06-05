package repository.impl;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import repository.CustomerRepository;
import javax.transaction.Transactional;


@Transactional
public class ICustomerRepository implements CustomerRepository {
    @Override
    public Iterable<Customer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Customer findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void delete(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
