package Update;

import Menu.DataSampah;
import Menu.MenuController;
import Menu.XML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnUbah;

    @FXML
    private TextField editHarga;

    @FXML
    private TextField editJenisSampah;

    @FXML
    private TextField editKode;

    @FXML
    private TextField editStok;

    @FXML
    private RadioButton editTersedia;

    @FXML
    private RadioButton editTidakTersedia;

    @FXML
    void handleBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    private DataSampah selectedDataSampah;

    @FXML
    void handleUbah(ActionEvent event) {
        MenuController.dataSampahList = FXCollections.observableArrayList();
        MenuController.dataSampahList.addAll(XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class));

        // Perbarui objek DataSampah yang dipilih dengan nilai baru
        selectedDataSampah.setJenisSampah(editJenisSampah.getText());
        selectedDataSampah.setKode(editKode.getText());
        selectedDataSampah.setHarga(Double.parseDouble(editHarga.getText()));
        selectedDataSampah.setStok(Integer.parseInt(editStok.getText()));
        selectedDataSampah.setStatus(editTersedia.isSelected() ? "Tersedia" : "Tidak Tersedia");

        // Remove the old object from the dataSampahList
        MenuController.dataSampahList.removeIf(data -> data.getKode().equals(selectedDataSampah.getKode()));

        // Add the updated object to the dataSampahList
        MenuController.dataSampahList.add(selectedDataSampah);

        // Save the dataSampahList to an XML file
        XML.writeXML("data_sampah.xml", MenuController.dataSampahList);

        // Refresh TableView to reflect the updated data
        TableView<DataSampah> tableView = MenuController.getInstance().getTV1();
        tableView.refresh();

        TableView<DataSampah> tableView1 = MenuController.getInstance().getTV3();
        tableView1.refresh();

        // Close the edit window
        closeWindow();
    }

    public void initData(DataSampah dataSampah) {
        selectedDataSampah = dataSampah;

        // Isi bidang teks dengan data dari objek DataSampah yang dipilih
        editJenisSampah.setText(dataSampah.getJenisSampah());
        editKode.setText(dataSampah.getKode());
        editHarga.setText(String.valueOf(dataSampah.getHarga()));
        editStok.setText(String.valueOf(dataSampah.getStok()));
        editTersedia.setSelected(dataSampah.getStatus().equals("Tersedia"));
        editTidakTersedia.setSelected(dataSampah.getStatus().equals("Tidak Tersedia"));
    }

    private void closeWindow() {
        // tutup the edit window
        Stage stage = (Stage) btnUbah.getScene().getWindow();
        stage.close();
    }

}
