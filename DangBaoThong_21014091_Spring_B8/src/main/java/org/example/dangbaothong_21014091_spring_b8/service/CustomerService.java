package org.example.dangbaothong_21014091_spring_b8.service;

import org.example.dangbaothong_21014091_spring_b8.entity.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
    public void deleteCustomer(int theId);
}