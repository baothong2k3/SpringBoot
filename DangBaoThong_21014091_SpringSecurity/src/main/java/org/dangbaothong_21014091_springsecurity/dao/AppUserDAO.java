/*
 * @ (#) AppUserDAO.java    1.0    27/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.dangbaothong_21014091_springsecurity.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 27/11/2024
 * @version: 1.0
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.dangbaothong_21014091_springsecurity.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
