/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemheadphone.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HeadphoneProperty {
    private StringProperty ID;
    private StringProperty nama;
    private StringProperty tanggalPembelian;
    private StringProperty jenis;
    private StringProperty merk;

    public HeadphoneProperty(String ID, String nama, String tanggalPembelian, String jenis, String merk) {
        this.ID = new SimpleStringProperty(ID);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalPembelian = new SimpleStringProperty(tanggalPembelian);
        this.jenis = new SimpleStringProperty(jenis);
        this.merk = new SimpleStringProperty(merk);
    }
    public HeadphoneProperty(Headphone hdp){
        this.ID = new SimpleStringProperty(hdp.getID());
        this.nama = new SimpleStringProperty(hdp.getNama());
        this.tanggalPembelian = new SimpleStringProperty(hdp.getTanggalPembelian());
        this.jenis = new SimpleStringProperty(hdp.getJenis());
        this.merk = new SimpleStringProperty(hdp.getMerk());
    }
    public StringProperty getProdiProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty(merk);
    }

    public StringProperty getIDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalPembelianProperty() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(String tanggalPembelian) {
        this.tanggalPembelian = new SimpleStringProperty(tanggalPembelian);
    }

    public StringProperty getJenisProperty() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = new SimpleStringProperty(jenis);
    }

    public String getID() {
        return ID.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalPembelian() {
        return tanggalPembelian.get();
    }

    public String getJenis() {
        return jenis.get();
    }

    public String getMerk() {
        return merk.get();
    }
    
}
