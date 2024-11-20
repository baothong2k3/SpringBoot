/*
 * @ (#) GiangVienDaoImpl.java    1.0    15/11/2024
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
import org.example.dangbaothong_21014091_spring_b9.entities.GIANGVIEN;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GiangVienDaoImpl implements GiangVienDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addGiangVien(GIANGVIEN giangVien) {
        entityManager.merge(giangVien);
    }

    @Override
    public List<GIANGVIEN> getAllGiangVien() {
        return entityManager.createQuery("from GIANGVIEN", GIANGVIEN.class)
                .getResultList();
    }

    @Override
    public GIANGVIEN getGiangVienById(int maGV) {
        return entityManager.find(GIANGVIEN.class, maGV);
    }

}
