/*
 * @ (#) AppUser.java    1.0    27/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.dangbaothong_21014091_springsecurity.entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 27/11/2024
 * @version: 1.0
 */

import jakarta.persistence.*;

@Entity
@Table(name = "App_User", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name")})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Long userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}