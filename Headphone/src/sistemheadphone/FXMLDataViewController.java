package sistemheadphone;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sistemheadphone.db.DBHandler;
import sistemheadphone.model.HeadphoneProperty;

public class FXMLDataViewController implements Initializable {

    @FXML
    private TableView<HeadphoneProperty> tblHeadphone;

    @FXML
    private TableColumn<HeadphoneProperty, String> colTglPembelian;

    @FXML
    private TableColumn<HeadphoneProperty, String> colid;

    @FXML
    private TableColumn<HeadphoneProperty, String> colNama;

    @FXML
    private TableColumn<HeadphoneProperty, String> colJenis;
    
    @FXML
    private TableColumn<HeadphoneProperty, String> colMerk;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataMahasiswa(ActionEvent event) {
        HeadphoneProperty hdp = tblHeadphone.getSelectionModel().getSelectedItem();
        int ans = JOptionPane.showConfirmDialog(null, "Yakin Akan Menghapus?");
        if (ans == JOptionPane.YES_OPTION) {
            DBHandler dh = new DBHandler("MYSQL");
            dh.deleteHeadphone(hdp);
            showDataHeadphone();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataHeadphone();

        tblHeadphone.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataHeadphone() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<HeadphoneProperty> data = dh.getHeadphone();
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        colTglPembelian.setCellValueFactory(new PropertyValueFactory<>("tanggalpembelian"));
        tblHeadphone.setItems(null);
        tblHeadphone.setItems(data);
    }
}
