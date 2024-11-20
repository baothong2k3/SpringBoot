/*
 * @ (#) DETAI.java    1.0    15/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b9.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "DETAI")
public class DETAI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MADETAI;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*(\\s[A-Z][a-zA-Z0-9]*)*$", message = "Each word must start with an uppercase letter, can contain numbers but no special characters")
    @Size(max = 100, message = "must not exceed 100 characters")
    private String TENDT;

    @NotNull(message = "is required")
    private String NAM;

    private String MOTADETAI;

    private String URLHINH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAGV")
    private GIANGVIEN giangvien;

    public DETAI(String TENDT, String NAM, String MOTADETAI, String URLHINH, GIANGVIEN giangvien) {
        this.TENDT = TENDT;
        this.NAM = NAM;
        this.MOTADETAI = MOTADETAI;
        this.URLHINH = URLHINH;
        this.giangvien = giangvien;
    }

    public DETAI() {
    }

    public int getMADETAI() {
        return MADETAI;
    }

    public String getTENDT() {
        return TENDT;
    }

    public void setTENDT(String TENDT) {
        this.TENDT = TENDT;
    }

    public String getNAM() {
        return NAM;
    }

    public void setNAM(String NAM) {
        this.NAM = NAM;
    }

    public String getMOTADETAI() {
        return MOTADETAI;
    }

    public void setMOTADETAI(String MOTADETAI) {
        this.MOTADETAI = MOTADETAI;
    }

    public String getURLHINH() {
        return URLHINH;
    }

    public void setURLHINH(String URLHINH) {
        this.URLHINH = URLHINH;
    }

    public GIANGVIEN getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(GIANGVIEN giangvien) {
        this.giangvien = giangvien;
    }

    @Override
    public String toString() {
        return "DETAI{" +
                "MADETAI=" + MADETAI +
                ", TENDT='" + TENDT + '\'' +
                ", NAM='" + NAM + '\'' +
                ", MOTADETAI='" + MOTADETAI + '\'' +
                ", URLHINH='" + URLHINH + '\'' +
                ", giangvien=" + giangvien +
                '}';
    }
}