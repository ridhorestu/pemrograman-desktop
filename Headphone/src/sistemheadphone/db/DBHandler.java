
package sistemheadphone.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistemheadphone.model.Headphone;
import sistemheadphone.model.HeadphoneProperty;

public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addHeadphone(Headphone str){
        String insertStr = "INSERT INTO `headphone`(`id`, `nama`, `tgl_pembelian`,`jenis`,`merk`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertStr);
            stmtInsert.setString(1, str.getID());
            stmtInsert.setString(2, str.getNama());
            stmtInsert.setString(3, str.getTanggalPembelian());
            stmtInsert.setString(4, str.getJenis());
            stmtInsert.setString(5, str.getMerk());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<HeadphoneProperty> getHeadphone(){
        ObservableList<HeadphoneProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT ID, nama, tgl_pembelian, jenis, merek FROM `setrika` ORDER BY ID";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                HeadphoneProperty str = new HeadphoneProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteHeadphone(HeadphoneProperty hdp){
        String deleteHdp = "DELETE FROM headphone WHERE `headphone`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteHdp);
            stmtDelete.setString(1, hdp.getID());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
