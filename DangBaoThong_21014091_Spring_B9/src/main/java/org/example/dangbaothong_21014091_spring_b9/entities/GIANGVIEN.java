/*
 * @ (#) GIANGVIEN.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.entities;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/11/2024
 * @version: 1.0
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "GIANGVIEN")
public class GIANGVIEN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MAGV;

    @NotNull(message = "Name is required")
    @Size(min = 1, message = "Name is required")
    private String TENGV;

    private String LINHVUCNGHIENCUU;

    @Pattern(regexp = "[0-9]{9,11}", message = "9-11 digits")
    private String DIENTHOAI;

    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.(com|net|org)\\.vn$", message = "Invalid email format")
    private String EMAIL;

    public int getMAGV() {
        return MAGV;
    }

    public void setMAGV(int MAGV) {
        this.MAGV = MAGV;
    }

    public String getTENGV() {
        return TENGV;
    }

    public void setTENGV(String TENGV) {
        this.TENGV = TENGV;
    }

    public String getLINHVUCNGHIENCUU() {
        return LINHVUCNGHIENCUU;
    }

    public void setLINHVUCNGHIENCUU(String LINHVUCNGHIENCUU) {
        this.LINHVUCNGHIENCUU = LINHVUCNGHIENCUU;
    }

    public String getDIENTHOAI() {
        return DIENTHOAI;
    }

    public void setDIENTHOAI(String DIENTHOAI) {
        this.DIENTHOAI = DIENTHOAI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public GIANGVIEN(String TENGV, String LINHVUCNGHIENCUU, String DIENTHOAI, String EMAIL) {
        this.TENGV = TENGV;
        this.LINHVUCNGHIENCUU = LINHVUCNGHIENCUU;
        this.DIENTHOAI = DIENTHOAI;
        this.EMAIL = EMAIL;
    }

    public GIANGVIEN() {
    }

    @Override
    public String toString() {
        return "GIANGVIEN{" +
                "MAGV=" + MAGV +
                ", TENGV='" + TENGV + '\'' +
                ", LINHVUCNGHIENCUU='" + LINHVUCNGHIENCUU + '\'' +
                ", DIENTHOAI='" + DIENTHOAI + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}
