/*
 * @ (#) GiangVienDao.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_spring_b9.entities.GIANGVIEN;

import java.util.List;

public interface GiangVienDao {
    public void addGiangVien(GIANGVIEN giangVien);

    public List<GIANGVIEN> getAllGiangVien();

    public GIANGVIEN getGiangVienById(int maGV);
}
