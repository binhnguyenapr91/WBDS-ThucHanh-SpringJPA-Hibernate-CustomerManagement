package repository.impl;

import model.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ICustomerRepository implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer as c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getById(Long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer as c where c.id=:id" ,Customer.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model.getId()!=null){
            em.merge(model);
        }else em.persist(model);
    }

    @Override
    public void remove(Long id) {
        Customer customer = getById(id);
        if (customer != null){
            em.remove(customer);
        }
    }
}
