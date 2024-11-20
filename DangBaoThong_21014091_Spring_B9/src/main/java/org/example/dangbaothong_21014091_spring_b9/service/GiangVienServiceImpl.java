/*
 * @ (#) GiangVienServiceImpl.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.service;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_spring_b9.dao.GiangVienDao;
import org.example.dangbaothong_21014091_spring_b9.entities.GIANGVIEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiangVienServiceImpl implements GiangVienService {
    @Autowired
    private GiangVienDao giangVienDao;

    @Override
    @Transactional
    public void addGiangVien(GIANGVIEN giangVien) {
        giangVienDao.addGiangVien(giangVien);
    }

    @Override
    @Transactional
    public List<GIANGVIEN> getAllGiangVien() {
        return giangVienDao.getAllGiangVien();
    }

    @Override
    @Transactional
    public GIANGVIEN getGiangVienById(int maGV) {
        return giangVienDao.getGiangVienById(maGV);
    }
}
