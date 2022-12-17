public class Atm extends SuaraAtm implements Cek{
 private String suara;
  public Atm (String nama, int jmlsetoran, String suara){
  super(nama, jmlsetoran);
  this.suara=suara;
 }
 public void displayMasukkanKartu(){
  System.out.println("Cek Saldo : " + getNama());
  System.out.println("Tarik Uang : " + getSuara());
 }
 public void displayData(){
  displayMasukkanKartu();
  System.out.println("Suara : "+suara);
 }
}