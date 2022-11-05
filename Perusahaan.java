package AplikasiNasabah;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Perusahaan extends Nasabah{
    private StringProperty nib;
    
    public Perusahaan(String nib, Integer nasabahID, String nama, String alamat,
                        ArrayList<Rekening> rekenings) {
        super(nasabahID, nama, alamat, rekenings);
        this.nib = new SimpleStringProperty(nib);
    }
    
    public Perusahaan(String nib, Integer nasabahID, String nama, String alamat, 
                        Rekening rekening) {
        super(nasabahID, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }
    
    public String getNib() {
        return nib.get();
    }
    
    public void setNib(String nib) {
        this.nib.set(nib);
    }
    
    public StringProperty nibProperty() {
        return nib;
    }
}