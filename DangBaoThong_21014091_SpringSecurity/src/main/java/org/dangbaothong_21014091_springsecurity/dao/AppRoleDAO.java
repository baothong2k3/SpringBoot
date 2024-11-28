/*
 * @ (#) AppRoleDAO.java    1.0    27/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.dangbaothong_21014091_springsecurity.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 27/11/2024
 * @version: 1.0
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.dangbaothong_21014091_springsecurity.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppRoleDAO {
    @Autowired
    private EntityManager entityManager;

    public List getRoleNames(Long userId) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userId = :userId ";

        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
