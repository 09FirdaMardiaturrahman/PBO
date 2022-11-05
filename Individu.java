package AplikasiNasabah;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Individu extends Nasabah{
    private StringProperty nik;
    private StringProperty npwp;

    public Individu(String nik, String npwp, Integer nasabahID, String nama, 
                        String alamat, ArrayList<Rekening> rekenings) {
        super(nasabahID, nama, alamat, rekenings);
        this.nik = new SimpleStringProperty(nik);
        this.npwp = new SimpleStringProperty(npwp);
    }
    
    public Individu(String nik, String npwp, Integer nasabahID, String nama, 
                        String alamat, Rekening rekening) {
        super(nasabahID, nama, alamat, rekening);
        this.nik = new SimpleStringProperty(nik);
        this.npwp = new SimpleStringProperty(npwp);
    }
    
    public String getNik() {
        return nik.get();
    }
    
    public void setNik(String nik) {
        this.nik.set(nik);
    }
    
    public String getNpwp() {
        return npwp.get();
    }
    
    public void setNpwp(String npwp) {
        this.npwp.set(npwp);
    }
    
    public StringProperty nikProperty(){
        return nik;
    }
    
    public StringProperty npwpProperty(){
        return npwp;
    }
}