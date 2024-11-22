/*
 * @ (#) EmployeeService.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.services;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_springapi.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public Employee findById(int id);
    public List<Employee> findAll();
    public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
    public Employee save(Employee employee);
    public Employee update(int id, Employee employee);
    public boolean delete(int id);
    public List<Employee> search(String keyword);
}
