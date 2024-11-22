/*
 * @ (#) Employee.java    1.0    22/11/2024
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "First Name must not be Null")
    @NotEmpty(message = "First Name must not be Empty")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last Name must not be Null")
    @NotEmpty(message = "Last Name must not be Empty")
    private String lastName;

    private String gender;

    @Column(name = "email")
    @NotEmpty(message = "Email must not be Empty")
    @Email(message = "Email should be valid")
    private String emailAddress;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please input phone number with format: (NNN)NNN-NNNN")
    private String phoneNumber;

    @Past(message = "Date of birth must be less than today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonIgnore
    private Address address;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String gender, String emailAddress, String phoneNumber, Date dob, Date createdDate, Date modifiedDate, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "First Name must not be Null") @NotEmpty(message = "First Name must not be Empty") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "First Name must not be Null") @NotEmpty(message = "First Name must not be Empty") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "Last Name must not be Null") @NotEmpty(message = "Last Name must not be Empty") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "Last Name must not be Null") @NotEmpty(message = "Last Name must not be Empty") String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public @NotEmpty(message = "Email must not be Empty") @Email(message = "Email should be valid") String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(@NotEmpty(message = "Email must not be Empty") @Email(message = "Email should be valid") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please input phone number with format: (NNN)NNN-NNNN") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please input phone number with format: (NNN)NNN-NNNN") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Past(message = "Date of birth must be less than today") Date getDob() {
        return dob;
    }

    public void setDob(@Past(message = "Date of birth must be less than today") Date dob) {
        this.dob = dob;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "modifiedDate=" + modifiedDate +
                ", createdDate=" + createdDate +
                ", dob=" + dob +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
