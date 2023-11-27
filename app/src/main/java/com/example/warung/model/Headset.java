package com.example.warung.model;

public class Headset {
    private String nama, merk, harga, gambar, gambar2, cablelength, audiojack, speakersize, color;


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

    public String getCablelength() {
        return cablelength;
    }

    public String getAudiojack() {
        return audiojack;
    }

    public String getSpeakersize() {
        return speakersize;
    }

    public String getColor() {
        return color;
    }

    public Headset(String nama, String merk, String herga, String gambar, String gambar2, String cablelength, String audiojack, String speakersize, String color){
        this.nama = nama;
        this.merk = merk;
        this.harga = herga;
        this.gambar = gambar;
        this.gambar2 = gambar2;
        this.cablelength = cablelength;
        this.audiojack = audiojack;
        this.speakersize = speakersize;
        this.color = color;
    }
}
