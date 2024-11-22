/*
 * @ (#) Address.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.entities;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 5, message = "Address cannot exceed 255 characters")
    private String address;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonIgnore
    private Employee employee;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 5, message = "Address cannot exceed 255 characters") String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 5, message = "Address cannot exceed 255 characters") String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
