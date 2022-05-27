/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemheadphone.model;

/**
 *
 * @author didik
 */
public class Headphone {
    private String ID;
    private String nama;
    private String tanggalPembelian;
    private String jenis;
    private String merk;

    public Headphone(String id, String nama, String tanggalProduksi, String jenis, String merk) {
        this.ID = ID;
        this.nama = nama;
        this.tanggalPembelian = tanggalProduksi;
        this.jenis = jenis;
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembeliani(String tanggalProduksi) {
        this.tanggalPembelian= tanggalProduksi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
}
