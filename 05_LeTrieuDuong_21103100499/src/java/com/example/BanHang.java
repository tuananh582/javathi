/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

/**
 *
 * @author duong
 */
public class BanHang {
      private String MaKH;
    private String MaSP;
    private double GiaSP;
    private int SoLuong;

    public BanHang() {
    }

    public BanHang(String MaKH, String MaSP, double GiaSP, int SoLuong) {
        this.MaKH = MaKH;
        this.MaSP = MaSP;
        this.GiaSP = GiaSP;
        this.SoLuong = SoLuong;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public double getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(double GiaSP) {
        this.GiaSP = GiaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}


