/*
 * @ (#) CustomerDAO.java    1.0    14/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b8.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_spring_b8.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAllCustomer();
    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
    public void deleteCustomer(int theId);
}
