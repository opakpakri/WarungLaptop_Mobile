package com.example.warung.model;

public class Laptop {
    private String nama, merk, harga, gambar, gambar2, processor, gpu, os, ram, storage, display;

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

    public String getProcessor() {
        return processor;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getDisplay() {
        return display;
    }

    public Laptop(String nama, String merk, String herga, String gambar, String gambar2, String processor, String gpu, String os, String ram, String storage, String display){
        this.nama = nama;
        this.merk = merk;
        this.harga = herga;
        this.gambar = gambar;
        this.gambar2 = gambar2;
        this.processor = processor;
        this.gpu = gpu;
        this.os = os;
        this.ram  = ram;
        this.storage = storage;
        this.display = display;
    }
}
