/*
 * @ (#) DeTaiServiceImpl.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.service;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_spring_b9.dao.DeTaiDao;
import org.example.dangbaothong_21014091_spring_b9.entities.DETAI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeTaiServiceImpl implements DeTaiService {

    @Autowired
    private DeTaiDao deTaiDao;

    @Override
    @Transactional
    public void addDeTai(DETAI deTai) {
        deTaiDao.addDeTai(deTai);
    }

    @Override
    @Transactional
    public void deleteDeTai(int theId) {
        deTaiDao.deleteDeTai(theId);
    }

    @Override
    @Transactional
    public List<DETAI> getDeTaiByGiangVien(int maGV) {
        return deTaiDao.getDeTaiByGiangVien(maGV);
    }

    @Override
    @Transactional
    public DETAI getDeTai(int theId) {
        return deTaiDao.getDeTai(theId);
    }
}
