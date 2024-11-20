/*
 * @ (#) DeTaiDao.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_spring_b9.entities.DETAI;

import java.util.List;

public interface DeTaiDao {
    public void addDeTai(DETAI deTai);

    public void deleteDeTai(int theId);

    public List<DETAI> getDeTaiByGiangVien(int maGV);

    public DETAI getDeTai(int theId);
}
