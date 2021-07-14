package com.example.sinhvien.model;

public class Sanpham {
    private int ID;
    private String TenSP;
    private String Gia;
    private String Anh;
    private int ID_TK;

    public Sanpham(int ID, String tenSP, String gia, String anh, int ID_TK) {
        this.ID = ID;
        TenSP = tenSP;
        Gia = gia;
        Anh = anh;
        this.ID_TK = ID_TK;
    }

    public Sanpham(String tenSP, String gia, String anh, int ID_TK) {
        TenSP = tenSP;
        Gia = gia;
        Anh = anh;
        this.ID_TK = ID_TK;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public int getID_TK() {
        return ID_TK;
    }

    public void setID_TK(int ID_TK) {
        this.ID_TK = ID_TK;
    }
}
