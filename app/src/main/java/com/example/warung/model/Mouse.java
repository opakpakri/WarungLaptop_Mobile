package com.example.warung.model;

public class Mouse {
    private String nama, merk, harga, gambar, gambar2, dpi, button, sensor;

    public String getNama() {
        return nama;
    }

    public String getMerk() {
        return merk;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getGambar2() {
        return gambar2;
    }

    public String getDpi() {
        return dpi;
    }

    public String getButton() {
        return button;
    }

    public String getSensor() {
        return sensor;
    }

    public Mouse(String nama, String merk, String herga, String gambar, String gambar2, String dpi, String button, String sensor){
        this.nama = nama;
        this.merk = merk;
        this.harga = herga;
        this.gambar = gambar;
        this.gambar2 = gambar2;
        this.dpi = dpi;
        this.button = button;
        this.sensor = sensor;
    }
}
