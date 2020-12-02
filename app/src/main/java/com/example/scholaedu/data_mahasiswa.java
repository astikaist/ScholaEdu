package com.example.scholaedu;

public class data_mahasiswa {
    private String nama;
    private String jurusan;

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public data_mahasiswa() {
    }

    public data_mahasiswa(String nama, String jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }
}
