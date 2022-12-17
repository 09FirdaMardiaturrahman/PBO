public abstract class SuaraAtm{
 protected String nama;
 protected int jmlsetoran;
  public SuaraAtm(String nama, int jmlsetoran){
  this.nama=nama;
  this.jmlsetoran=jmlsetoran;
 }
  public void setNama(String nama){
  this.nama=nama;
 }
 public String getNama(){
  return nama;
 }
 public void setSuara(int jmlsetoran){
  this.jmlsetoran=jmlsetoran;
 }
 public int getSuara(){
  return jmlsetoran;
 }
 public void displaySuaraAtm(){
  System.out.println("Nama    : "+getNama());
  System.out.println("Setoran : "+getSuara());
 }
 }