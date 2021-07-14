package com.example.sinhvien.model;

public class Taikhoan {
    private int idtk;
    private String tentk;
    private String mk;
    private String email;
    private int phanquyen;

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }

    public Taikhoan(String tentk, String mk, String email, int phanquyen) {
        this.tentk = tentk;
        this.mk = mk;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public Taikhoan(String tentk, String email) {
        this.tentk = tentk;
        this.email = email;
    }

}
