/*package AplikasiNasabah;

import dbNasabah.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NasabahDataModel {
    public final Connection conn;
    
    public NasabahDataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    
    public void addNasabah(Individu nb) throws SQLException{
        String insertNb = "INSERT INTO nasabah (nasabah_id, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertIndividu = "INSERT INTO individu (nasabah_id, nik, npwp)"
                + " VALUES (?,?,?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, nasabah_id)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtNb = conn.prepareStatement(insertNb);
        stmtNb.setInt(1, nb.getNasabahID());
        stmtNb.setString(2, nb.getNama());
        stmtNb.setString(3, nb.getAlamat());
        stmtNb.execute();
        
        PreparedStatement stmtIndividu = conn.prepareStatement(insertIndividu);
        stmtIndividu.setInt(1, nb.getNasabahID());
        stmtIndividu.setString(2, nb.getNik());
        stmtIndividu.setString(3, nb.getNpwp());
        stmtIndividu.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, nb.getRekenings().get(0).getNoRekening());
        stmtRekening.setDouble(2, nb.getRekenings().get(0).getSaldo());
        stmtRekening.setInt(3, nb.getNasabahID());
        stmtRekening.execute();
    }
    
    public void addNasabah(Perusahaan nb) throws SQLException{
        String insertNb = "INSERT INTO nasabah (nasabah_id, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertPerusahaan = "INSERT INTO perusahaan (nasabah_id, nib)"
                + " VALUES (?,?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, nasabah_id)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtNb = conn.prepareStatement(insertNb);
        stmtNb.setInt(1, nb.getNasabahID());
        stmtNb.setString(2, nb.getNama());
        stmtNb.setString(3, nb.getAlamat());
        stmtNb.execute();
        
        PreparedStatement stmtIndividu = conn.prepareStatement(insertPerusahaan);
        stmtIndividu.setInt(1, nb.getNasabahID());
        stmtIndividu.setString(2, nb.getNib());
        stmtIndividu.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, nb.getRekenings().get(0).getNoRekening());
        stmtRekening.setDouble(2, nb.getRekenings().get(0).getSaldo());
        stmtRekening.setInt(3, nb.getNasabahID());
        stmtRekening.execute();
    }
    
    public ObservableList<Individu> getIndividu(){
        ObservableList<Individu> data = FXCollections.observableArrayList();
        String sql="SELECT nasabah_id, nama, alamat, nik, npwp "
                + "FROM nasabah NATURAL JOIN individu ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT no_rekening, saldo "
                    + "FROM rekening WHERE nasabah_id=" + rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                data.add(new Individu(rs.getString(4), rs.getString(5), rs.getInt(1),
                        rs.getString(2),rs.getString(3), dataRekening));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }
    
    public ObservableList<Perusahaan> getPerusahaan(){
        ObservableList<Perusahaan> data = FXCollections.observableArrayList();
        String sql="SELECT nasabah_id, nama, alamat, nib "
                + "FROM nasabah NATURAL JOIN perusahaan ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT no_rekening, saldo "
                    + "FROM rekening WHERE nasabah_id="+rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                data.add(new Perusahaan(rs.getString(4),rs.getInt(1),rs.getString(2),rs.getString(3), dataRekening));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }
    
    public ObservableList<Rekening> getRekening (int nbID){
        ObservableList<Rekening> data = FXCollections.observableArrayList();
        String sql="SELECT no_rekening, saldo FROM rekening WHERE nasabah_id="+nbID;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                data.add(new Rekening(rs.getInt(1),rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public int nextNasabahID() throws SQLException{
        String sql="SELECT MAX(nasabah_id) from nasabah";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?1000001:rs.getInt(1)+1;
            }
        return 1000001;
    }
    
    public int nextNomorRekening(int nbID) throws SQLException{
        String sql="SELECT MAX(no_rekening) FROM rekening WHERE nasabah_id="+nbID;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)+1;
            }
        return 0;
    }
    
    public void addRekening(int nasabahID, Rekening rek) throws SQLException{
        String insertNb = "INSERT INTO rekening (nasabah_id, no_rekening, saldo)"
                + " VALUES (?,?,?)";
  
        PreparedStatement stmtNb = conn.prepareStatement(insertNb);
        stmtNb.setInt(1, nasabahID);
        stmtNb.setInt(2, rek.getNoRekening());
        stmtNb.setDouble(3, rek.getSaldo());
        stmtNb.execute();
    }
    
    public void updateSaldo(int noRekening, double saldo) throws SQLException{
        String updateNb = "UPDATE rekening SET saldo = ? WHERE no_rekening = ?";
        
        PreparedStatement stmtNb = conn.prepareStatement(updateNb);
        stmtNb.setDouble(1, saldo);
        stmtNb.setInt(2, noRekening);
        stmtNb.execute();
    }
}*/