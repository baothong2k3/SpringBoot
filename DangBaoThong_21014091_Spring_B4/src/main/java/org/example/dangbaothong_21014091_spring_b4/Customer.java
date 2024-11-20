/*
 * @ (#) Customer.java    1.0    14/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b4;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/11/2024
 * @version: 1.0
 */

import jakarta.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required")
    @Size(min = 2, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 2, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "[a-zA-Z0-9]{5}", message = "5 characters/digits")
    private String postalCode;

    private String courseCode;

    public @NotNull(message = "is required") @Size(min = 2, message = "is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "is required") @Size(min = 2, message = "is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "is required") @Size(min = 2, message = "is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "is required") @Size(min = 2, message = "is required") String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "[a-zA-Z0-9]{5}", message = "5 characters/digits") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "[a-zA-Z0-9]{5}", message = "5 characters/digits") String postalCode) {
        this.postalCode = postalCode;
    }

    public @NotNull(message = "is required") @Min(value = 0, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@NotNull(message = "is required") @Min(value = 0, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
