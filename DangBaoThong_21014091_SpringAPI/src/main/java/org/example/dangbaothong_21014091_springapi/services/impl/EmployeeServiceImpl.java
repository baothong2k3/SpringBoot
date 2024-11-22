/*
 * @ (#) EmployeeServiceImpl.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.services.impl;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_springapi.entities.Employee;
import org.example.dangbaothong_21014091_springapi.exceptions.ItemNotFoundException;
import org.example.dangbaothong_21014091_springapi.repositories.EmployeeRepository;
import org.example.dangbaothong_21014091_springapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Can not find Employee with id: " + id));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) {
        // Check id exists or not
        this.findById(id);
        // Update
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean delete(int id) {
        Employee employee = this.findById(id);
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public List<Employee> search(String keyword) {
        return employeeRepository.search(keyword);
    }
}
