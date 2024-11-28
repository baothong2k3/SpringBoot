/*
 * @ (#) AppRole.java    1.0    27/11/2024
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
@Table(name = "App_Role", uniqueConstraints = {@UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name")})
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
