package AplikasiNasabah;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Rekening {
    private IntegerProperty noRekening;
    private DoubleProperty saldo;
    
    public Rekening(int noRekening, double saldo) {
        this.noRekening = new SimpleIntegerProperty(noRekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }
    
    public Double getSaldo() {
        return saldo.get();
    }
    
    public void setSaldo(double saldo) {
        this.saldo.set(saldo);
    }
    
    public Integer getNoRekening() {
        return noRekening.get();
    }
    
    public void setNoRekening(int noRekening) {
        this.noRekening.set(noRekening);
    }
    
    public void tambahSaldo(double jumlah){
        this.saldo.set(this.saldo.get()+jumlah);
    }
    
    public void tarikSaldo(double jumlah){
        this.saldo.set(this.saldo.get()-jumlah);
    }
    
    public IntegerProperty noRekeningProperty(){
        return noRekening;
    }
    
    public DoubleProperty saldoProperty(){
        return saldo;
    }
}