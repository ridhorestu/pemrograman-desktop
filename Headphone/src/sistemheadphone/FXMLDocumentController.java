
package sistemheadphone;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sistemheadphone.db.DBHandler;
import sistemheadphone.model.Headphone;

public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbMerk;

    @FXML
    private DatePicker dpTanggalPembelian;

    @FXML
    private ToggleGroup jenis;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdClosed;

    @FXML
    private RadioButton rdOpen;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello "+tfNama.getText());
        System.out.println(tfID.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalPembelian.getValue().toString());
        String jenis="";
        if (rdClosed.isSelected())
           jenis=rdClosed.getText();
        if (rdOpen.isSelected())
           jenis=rdOpen.getText();
        
        System.out.println(jenis);
        System.out.println(cbMerk.getValue().toString());
//        Headphone(String npm, String nama, String tanggalLahir, String gender, String prodi)
        Headphone hdp = new Headphone(tfID.getText(),tfNama.getText(),dpTanggalPembelian.getValue().toString(),
            jenis,cbMerk.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addHeadphone(hdp);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataHeadphone();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Logitech G733");
        list.add("Razer BlackShark V2 Pro");
        ObservableList items = FXCollections.observableArrayList(list);
        cbMerk.setItems(items);
    }    
    
}
