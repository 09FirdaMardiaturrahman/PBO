package AplikasiNasabah;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Nasabah {
    private IntegerProperty nasabahID;
    private StringProperty nama;
    private StringProperty alamat;
    private ArrayList <Rekening> rekenings;
    
    public Nasabah(Integer nasabahID, String nama, String alamat, 
                    ArrayList<Rekening> rekenings) {
        this.nasabahID = new SimpleIntegerProperty(nasabahID);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekenings = rekenings;
    }
    
    public Nasabah(Integer nasabahID, String nama, String alamat, 
                    Rekening rekening) {
        rekenings = new ArrayList<>();
        this.nasabahID = new SimpleIntegerProperty(nasabahID);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekenings.add(rekening);
    }
    
    public Integer getNasabahID() {
        return nasabahID.get();
    }
    
    public void setNasabahID(Integer nasabahID) {
        this.nasabahID.set(nasabahID);
    }
    
    public String getNama() {
        return nama.get();
    }
    
    public void setNama(String nama) {
        this.nama.set(nama);
    }
    
    public String getAlamat() {
        return alamat.get();
    }
    
    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }
    
    public ArrayList<Rekening> getRekenings() {
        return rekenings;
    }
    
    public void setRekenings(ArrayList<Rekening> rekenings) {
        this.rekenings = rekenings;
    }
    
    public IntegerProperty nasabahIDProperty(){
        return nasabahID;
    }
    
    public StringProperty namaProperty(){
        return nama;
    }
    
    public StringProperty alamatProperty(){
        return alamat;
    }
}