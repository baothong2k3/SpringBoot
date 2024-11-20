/*
 * @ (#) DeTaiDaoImpl.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dangbaothong_21014091_spring_b9.entities.DETAI;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DeTaiDaoImpl implements DeTaiDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDeTai(DETAI deTai) {
        entityManager.merge(deTai);
    }

    @Override
    public void deleteDeTai(int theId) {
        DETAI deTai = entityManager.find(DETAI.class, theId);
        if (deTai != null) {
            entityManager.remove(deTai);
        }
    }

    @Override
    public List<DETAI> getDeTaiByGiangVien(int maGV) {
        return entityManager.createQuery("from DETAI where giangvien.MAGV = :maGV", DETAI.class)
                .setParameter("maGV", maGV)
                .getResultList();
    }

    @Override
    public DETAI getDeTai(int theId) {
        return entityManager.find(DETAI.class, theId);
    }
}
