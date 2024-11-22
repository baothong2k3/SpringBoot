/*
 * @ (#) EmployeeRepository.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.repositories;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_springapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e FROM Employee e WHERE e.firstName LIKE %:keyword%"
            + " OR e.lastName LIKE %:keyword%"
            + " OR e.emailAddress LIKE %:keyword%"
            + " OR e.phoneNumber LIKE %:keyword%")
    List<Employee> search(@Param("keyword") String keyword);
}
