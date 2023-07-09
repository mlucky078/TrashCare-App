package Update;

import Menu.DataSampah;
import Menu.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TambahController {
    @FXML
    private BorderPane BP;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnTmbh;

    @FXML
    private TextField tmbhHarga;

    @FXML
    private TextField tmbhJenisSampah;

    @FXML
    private TextField tmbhKode;

    @FXML
    private TextField tmbhStok;

    @FXML
    private RadioButton tmbhTersedia;

    @FXML
    private RadioButton tmbhTidakTersedia;

    @FXML
    void handleBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleTambah(ActionEvent event) {
        String kode = tmbhKode.getText();
        String jenisSampah = tmbhJenisSampah.getText();
        double harga = Double.parseDouble(tmbhHarga.getText());
        int stok = Integer.parseInt(tmbhStok.getText());
        String status = tmbhTersedia.isSelected() ? "Tersedia" : "Tidak Tersedia";

        DataSampah dataSampah = new DataSampah(kode, jenisSampah, harga, stok, status);

        MenuController menuController = MenuController.getInstance();
        menuController.addDataSampah(dataSampah);

        System.out.println("BERHASIL HANDLETAMBAH ");

        // Close the Tambah window
        btnTmbh.getScene().getWindow().hide();
    }

}
