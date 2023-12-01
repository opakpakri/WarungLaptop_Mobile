package com.example.warung.model;

public class Keyboard {
    private String nama, merk, harga, gambar, gambar2, jumlahtombol, konektivitas, kompatibilitas, ukuran;

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

    public String getJumlahtombol() {
        return jumlahtombol;
    }

    public String getKonektivitas() {
        return konektivitas;
    }

    public String getKompatibilitas() {
        return kompatibilitas;
    }

    public String getUkuran() {
        return ukuran;
    }

    public Keyboard(String nama, String merk, String herga, String gambar, String gambar2, String jumlahtombol, String konektivitas, String kompatibilitas, String ukuran){
        this.nama = nama;
        this.merk = merk;
        this.harga = herga;
        this.gambar = gambar;
        this.gambar2 = gambar2;
        this.jumlahtombol = jumlahtombol;
        this.konektivitas = konektivitas;
        this.kompatibilitas = kompatibilitas;
        this.ukuran = ukuran;
    }
}
