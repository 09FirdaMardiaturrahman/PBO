package AplikasiNasabah;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class NasabahFormController implements Initializable {
    NasabahDataModel ndm;
    
    @FXML
    private Label lblStatusIndi, lblStatusPeru, lblStatusTambahS, lblStatusTarikS;
    
    @FXML
    private TextField tfIdNbIndi, tfNamaIndi, tfAlamatIndi,
        tfNikIndi, tfNpwpIndi, tfNoRekIndi, tfSaldoIndi, 
            
            tfNewIdNbIndi, tfNewNoRekIndi, tfNewSaldoIndi,
            
            tfIdNbPeru, tfNamaPeru, tfAlamatPeru,
        tfNibPeru, tfNoRekPeru, tfSaldoPeru,
            
            tfNewIdNbPeru, tfNewNoRekPeru, tfNewSaldoPeru, 
            
            tfSearchIdNbTam, tfFixIdNbTam, tfFixNoRekTam, 
        tfNewSaldoTam,
            
            tfSearchIdNbTar, tfFixIdNbTar, tfFixNoRekTar, 
        tfNewSaldoTar;

    @FXML
    private Button btnTambahNbIndi, btnMuatUlangIndi, btnHapusIndi,
            btnTambahRekIndi,
            
            btnTambahNbPeru, btnMuatUlangPeru, btnHapusPeru,
            btnTambahRekPeru,
    
            btnTambahSaldo, btnHapusTam, btnCariIdNbTam,
            
            btnTarikSaldo, btnHapusTar, btnCariIdNbTar;
    
    
    //----------INDIVIDU---------------
    @FXML
    private TableView<Individu> tblNasabahIndi;

    @FXML
    private TableColumn<Individu, Integer> colIdNasabahIndi;

    @FXML
    private TableColumn<Individu, String> colNamaIndi;

    @FXML
    private TableColumn<Individu, String> colAlamatIndi;

    @FXML
    private TableColumn<Individu, String> colNikIndi;

    @FXML
    private TableColumn<Individu, String> colNpwpIndi;

    @FXML
    private TableView<Rekening> tblRekIndi;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekIndi;

    @FXML
    private TableColumn<Rekening, Double> colSaldoIndi;

    @FXML
    private AnchorPane fieldNewRekIndi;

    
    //----------PERUSAHAAN--------------
    @FXML
    private TableView<Perusahaan> tblNasabahPeru;

    @FXML
    private TableColumn<Perusahaan, Integer> colIdNasabahPeru;

    @FXML
    private TableColumn<Perusahaan, String> colNamaPeru;

    @FXML
    private TableColumn<Perusahaan, String> colAlamatPeru;

    @FXML
    private TableColumn<Perusahaan, String> colNibPeru;

    @FXML
    private TableView<Rekening> tblRekPeru;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekPeru;

    @FXML
    private TableColumn<Rekening, Double> colSaldoPeru;

    @FXML
    private AnchorPane fieldNewRekPeru;

    
    //----------TAMBAH SALDO---------------
    @FXML
    private TableView<Rekening> tblRekTam;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekTam;

    @FXML
    private TableColumn<Rekening, Double> colSaldoTam;
    
    //-----------Tarik Saldo--------------
    @FXML
    private TableView<Rekening> tblRekTar;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekTar;

    @FXML
    private TableColumn<Rekening, Double> colSaldoTar;

    @FXML
    void handleHapusIndiBtn(ActionEvent event) {
        try {
            tfIdNbIndi.setText(""+ndm.nextNasabahID());
            tfNoRekIndi.setText(tfIdNbIndi.getText()+"01");
            tfNamaIndi.setText("");
            tfAlamatIndi.setText("");
            tfNikIndi.setText("");
            tfNpwpIndi.setText("");
            tfSaldoIndi.setText("");
            tblRekIndi.setItems(null);
            tfNewIdNbIndi.setText("");
            fieldNewRekIndi.setVisible(false);
            btnTambahNbIndi.setDisable(true);
            tfNewSaldoIndi.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleHapusPeruBtn(ActionEvent event) {
        try {
            tfIdNbPeru.setText(""+ndm.nextNasabahID());
            tfNoRekPeru.setText(tfIdNbPeru.getText()+"01");
            tfNamaPeru.setText("");
            tfAlamatPeru.setText("");
            tfNibPeru.setText("");
            tfSaldoPeru.setText("");
            tblRekPeru.setItems(null);
            fieldNewRekPeru.setVisible(false);
            btnTambahNbPeru.setDisable(true);
            tfNewSaldoPeru.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleHapusTamBtn(ActionEvent event) {
        tfSearchIdNbTam.setText("");
        tfFixIdNbTam.setText("");
        tfFixNoRekTam.setText("");
        tfNewSaldoTam.setText("");
        btnTambahSaldo.setDisable(true);
        tblRekTam.setItems(null);
    }
    
    @FXML
    void handleHapusTarBtn(ActionEvent event) {
        tfSearchIdNbTar.setText("");
        tfFixIdNbTar.setText("");
        tfFixNoRekTar.setText("");
        tfNewSaldoTar.setText("");
        btnTarikSaldo.setDisable(true);
        tblRekTar.setItems(null);
    }

    @FXML
    void handleMuatUlangIndiBtn(ActionEvent event) {
        ObservableList<Individu> data = ndm.getIndividu();
        colIdNasabahIndi.setCellValueFactory(new PropertyValueFactory<>("nasabahID"));
        colNamaIndi.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatIndi.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNikIndi.setCellValueFactory(new PropertyValueFactory<>("nik"));
        colNpwpIndi.setCellValueFactory(new PropertyValueFactory<>("npwp"));
        tblNasabahIndi.setItems(null);
        tblNasabahIndi.setItems(data);
        fieldNewRekIndi.setVisible(false);
        btnTambahNbIndi.setDisable(false);
    }

    @FXML
    void handleMuatUlangPeruBtn(ActionEvent event) {
        ObservableList<Perusahaan> data = ndm.getPerusahaan();
        colIdNasabahPeru.setCellValueFactory(new PropertyValueFactory<>("nasabahID"));
        colNamaPeru.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatPeru.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNibPeru.setCellValueFactory(new PropertyValueFactory<>("nib"));
        tblNasabahPeru.setItems(null);
        tblNasabahPeru.setItems(data);
        fieldNewRekPeru.setVisible(false);
        btnTambahNbPeru.setDisable(false);
    }

    @FXML
    void handleTambahNbIndiBtn(ActionEvent event) {
        Individu nb = new Individu(tfNikIndi.getText(), tfNpwpIndi.getText(), 
                        Integer.parseInt(tfIdNbIndi.getText()), tfNamaIndi.getText(), 
                        tfAlamatIndi.getText(), new Rekening(Integer.parseInt(tfNoRekIndi.getText()), 
                        Double.parseDouble(tfSaldoIndi.getText())));
        try {
            ndm.addNasabah(nb);
            btnMuatUlangIndi.fire();
            btnHapusIndi.fire();
            btnMuatUlangPeru.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahNbPeruBtn(ActionEvent event) {
        Perusahaan nb = new Perusahaan(tfNibPeru.getText(), 
                Integer.parseInt(tfIdNbPeru.getText()), tfNamaPeru.getText(),
                tfAlamatPeru.getText(), new Rekening(Integer.parseInt(tfNoRekPeru.getText()),
                        Double.parseDouble(tfSaldoPeru.getText())));
        try {
            ndm.addNasabah(nb);
            btnMuatUlangPeru.fire();
            btnHapusPeru.fire();
            btnMuatUlangIndi.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahRekIndiBtn(ActionEvent event) {
        try {
            Rekening rek = new Rekening(Integer.parseInt(tfNewNoRekIndi.getText()),
                            Double.parseDouble(tfNewSaldoIndi.getText()));
            ndm.addRekening(Integer.parseInt(tfNewIdNbIndi.getText()),rek);
            viewDataRekeningIndividu(Integer.parseInt(tfNewIdNbIndi.getText()));
            btnMuatUlangIndi.fire();
            tfNewSaldoIndi.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahRekPeruBtn(ActionEvent event) {
        try {
            Rekening rek = new Rekening(Integer.parseInt(tfNewNoRekPeru.getText()),
                        Double.parseDouble(tfNewSaldoPeru.getText()));
            ndm.addRekening(Integer.parseInt(tfNewIdNbPeru.getText()), rek);
            viewDataRekeningPerusahaan(Integer.parseInt(tfNewIdNbPeru.getText()));
            btnMuatUlangPeru.fire();
            tfNewSaldoPeru.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahSaldoBtn(ActionEvent event) {
        Rekening rek = tblRekTam.getSelectionModel().getSelectedItem();
        try {
             ndm.updateSaldo(rek.getNoRekening(), Double.parseDouble(tfNewSaldoTam.getText())<=0
                     ?rek.getSaldo():rek.getSaldo()+Double.parseDouble(tfNewSaldoTam.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnHapusTam.fire();
    }
    
    @FXML
    void handleCariIdNbTamBtn(ActionEvent event) {
        tfFixIdNbTam.setText("");
        tfFixNoRekTam.setText("");
        tfNewSaldoTam.setText("");
        btnTambahSaldo.setDisable(true);
        tblRekTam.setItems(null);
        viewDataRekeningTambahSaldo(Integer.parseInt(tfSearchIdNbTam.getText()));
    }
    
    @FXML
    void handleTarikSaldoBtn(ActionEvent event) {
        Rekening rek = tblRekTar.getSelectionModel().getSelectedItem();
        try {
             ndm.updateSaldo(rek.getNoRekening(), rek.getSaldo()-Double.parseDouble(tfNewSaldoTar.getText())<=0
                     ?rek.getSaldo():rek.getSaldo()-Double.parseDouble(tfNewSaldoTar.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnHapusTar.fire();
    }
    
    @FXML
    void handleCariIdNbTarBtn(ActionEvent event) {
        tfFixIdNbTar.setText("");
        tfFixNoRekTar.setText("");
        tfNewSaldoTar.setText("");
        btnTarikSaldo.setDisable(true);
        tblRekTar.setItems(null);
        viewDataRekeningTarikSaldo(Integer.parseInt(tfSearchIdNbTar.getText()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ndm = new NasabahDataModel("SQLITE");
            setStatus(ndm.conn!=null?"Terkoneksi":"");
            tfIdNbIndi.setText(Integer.toString(ndm.nextNasabahID()));
            tfNoRekIndi.setText(Integer.toString(ndm.nextNasabahID())+"01");
            fieldNewRekIndi.setVisible(false);
            btnHapusIndi.fire();
            btnMuatUlangIndi.fire();
            
            tfIdNbPeru.setText(Integer.toString(ndm.nextNasabahID()));
            tfNoRekPeru.setText(Integer.toString(ndm.nextNasabahID())+"01");
            fieldNewRekPeru.setVisible(false);
            btnHapusPeru.fire();
            btnMuatUlangPeru.fire();
            
            btnTambahSaldo.setDisable(true);
            btnTarikSaldo.setDisable(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblNasabahIndi.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblNasabahIndi.getSelectionModel().getSelectedItem()!=null){
                Individu nb = tblNasabahIndi.getSelectionModel().getSelectedItem();
                viewDataRekeningIndividu(nb.getNasabahID());
                fieldNewRekIndi.setVisible(true);
                btnTambahNbIndi.setDisable(true);
                tfNewIdNbIndi.setText(""+nb.getNasabahID());
                try {
                    tfNewNoRekIndi.setText(""+ndm.nextNomorRekening(nb.getNasabahID()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        tblNasabahPeru.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblNasabahPeru.getSelectionModel().getSelectedItem()!=null){
                Perusahaan nb = tblNasabahPeru.getSelectionModel().getSelectedItem();
                viewDataRekeningPerusahaan(nb.getNasabahID());
                fieldNewRekPeru.setVisible(true);
                btnTambahNbPeru.setDisable(true);
                tfNewIdNbPeru.setText(""+nb.getNasabahID());
                try {
                    tfNewNoRekPeru.setText(""+ndm.nextNomorRekening(nb.getNasabahID()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        tblRekTam.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblRekTam.getSelectionModel().getSelectedItem()!=null){
                Rekening rek = tblRekTam.getSelectionModel().getSelectedItem();
                tfFixNoRekTam.setText(""+rek.getNoRekening());
                tfFixIdNbTam.setText(tfSearchIdNbTam.getText());
                btnTambahSaldo.setDisable(false);
            }
        });
        
        tblRekTar.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblRekTar.getSelectionModel().getSelectedItem()!=null){
                Rekening rek = tblRekTar.getSelectionModel().getSelectedItem();
                tfFixNoRekTar.setText(""+rek.getNoRekening());
                tfFixIdNbTar.setText(tfSearchIdNbTar.getText());
                btnTarikSaldo.setDisable(false);
            }
        });
    }
    
    public void setStatus(String ss){
        lblStatusIndi.setText(ss);
        lblStatusPeru.setText(ss);
        lblStatusTambahS.setText(ss);
        lblStatusTarikS.setText(ss);
    }
    
    public void viewDataRekeningIndividu(int nasabahID){
        ObservableList<Rekening> data = ndm.getRekening(nasabahID);
        colNoRekIndi.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoIndi.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekIndi.setItems(null);
        tblRekIndi.setItems(data);
    }
    
    public void viewDataRekeningPerusahaan(int nasabahID){
        ObservableList<Rekening> data = ndm.getRekening(nasabahID);
        colNoRekPeru.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoPeru.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekPeru.setItems(null);
        tblRekPeru.setItems(data);
    }
    
    public void viewDataRekeningTambahSaldo(int nasabahID){
        ObservableList<Rekening> data = ndm.getRekening(nasabahID);
        colNoRekTam.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoTam.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekTam.setItems(null);
        tblRekTam.setItems(data);
    }
    
    public void viewDataRekeningTarikSaldo(int nasabahID){
        ObservableList<Rekening> data = ndm.getRekening(nasabahID);
        colNoRekTar.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoTar.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekTar.setItems(null);
        tblRekTar.setItems(data);
    }
}