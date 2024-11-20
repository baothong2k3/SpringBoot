package org.example.dangbaothong_21014091_spring_b8.dao;

import org.example.dangbaothong_21014091_spring_b8.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomer() {
        return entityManager.createQuery("from Customer order by lastName", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        entityManager.merge(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        return entityManager.find(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Customer customer = entityManager.find(Customer.class, theId);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}