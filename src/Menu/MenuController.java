package Menu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import Update.EditController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    // HALAMAN SAMPAH

    @FXML
    private TableView<DataSampah> TV1;

    @FXML
    private TableColumn<DataSampah, Double> colHarga;

    @FXML
    private TableColumn<DataSampah, String> colJenisSampah;

    @FXML
    private TableColumn<DataSampah, String> colKode;

    @FXML
    private TableColumn<DataSampah, Integer> colNo;

    @FXML
    private TableColumn<DataSampah, String> colStatus;

    @FXML
    private TableColumn<DataSampah, Integer> colStok;

    @FXML
    private Button hapus;

    @FXML
    private TextField inSearch;

    @FXML
    private Label menuHome;

    @FXML
    private Label menuJual;

    @FXML
    private Label menuSampah;

    @FXML
    private Label menuTransaksi;

    @FXML
    private Button reset;

    @FXML
    private Button tambah;

    @FXML
    private Button update;

    @FXML
    private Button btnBDS;

    @FXML
    private Button btnBDP;

    @FXML
    private AnchorPane AP;

    @FXML
    private StackPane SP;

    @FXML
    private BorderPane BP;

    // HALAMAN HOME

    @FXML
    private AnchorPane sampahForm;

    @FXML
    private AnchorPane laporanForm;

    @FXML
    private AnchorPane backupForm;

    @FXML
    private Label menuBackup;

    @FXML
    private Label menuKeluar;

    @FXML
    private Label menuLaporan;

    @FXML
    private Button save;

    @FXML
    private AnchorPane back1;

    @FXML
    private AnchorPane back2;

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private AnchorPane homeForm;

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private Label TotalIncomeHome;

    @FXML
    private Label JenisSampahHome;

    // HALAMAN JUAL
    @FXML
    private TableView<DataPenjualan> TV11;

    @FXML
    private TableColumn<DataPenjualan, String> colJenisSampahJ;

    @FXML
    private TableColumn<DataPenjualan, LocalDate> colTanggalJ;

    @FXML
    private TableColumn<DataPenjualan, String> colPengepulJ;

    @FXML
    private TableColumn<DataPenjualan, Integer> colJumlahJ;

    @FXML
    private TableColumn<DataPenjualan, Double> colHargaJ;

    @FXML
    private TableColumn<DataPenjualan, Double> colTotalJ;

    @FXML
    private ComboBox<DataSampah> jenisSampahP;

    @FXML
    private DatePicker TglP;

    @FXML
    private TextField pengepulP;

    @FXML
    private TextField StokP;

    @FXML
    private TextField HargaP;

    @FXML
    private TextField TotalP;

    @FXML
    private Button bayar;

    @FXML
    private AnchorPane jualForm;

    // LAPORAN
    @FXML
    private TableView<DataSampah> TV3;

    @FXML
    private TableColumn<DataSampah, Double> colHargaSL;

    @FXML
    private TableColumn<DataSampah, String> colJenisSampahSL;

    @FXML
    private TableColumn<DataSampah, String> colKodeSL;

    @FXML
    private TableColumn<DataSampah, Integer> colNoSL;

    @FXML
    private TableColumn<DataSampah, String> colStatusSL;

    @FXML
    private TableColumn<DataSampah, Integer> colStokSL;

    @FXML
    private TableView<DataPenjualan> TV4;

    @FXML
    private TableColumn<DataPenjualan, String> colJenisSampahJL;

    @FXML
    private TableColumn<DataPenjualan, LocalDate> colTanggalJL;

    @FXML
    private TableColumn<DataPenjualan, String> colPengepulJL;

    @FXML
    private TableColumn<DataPenjualan, Integer> colJumlahJL;

    @FXML
    private TableColumn<DataPenjualan, Double> colHargaJL;

    @FXML
    private TableColumn<DataPenjualan, Double> colTotalJL;

    @FXML
    private ComboBox<DataSampah> jenisSampahPL;

    @FXML
    public void switchForm(MouseEvent event) {
        if (event.getSource() == menuHome) {
            homeForm.setVisible(true);
            sampahForm.setVisible(false);
            jualForm.setVisible(false);
            laporanForm.setVisible(false);
            backupForm.setVisible(false);

        } else if (event.getSource() == menuSampah) {
            homeForm.setVisible(false);
            sampahForm.setVisible(true);
            jualForm.setVisible(false);
            laporanForm.setVisible(false);
            backupForm.setVisible(false);
        } else if (event.getSource() == menuJual) {
            homeForm.setVisible(false);
            sampahForm.setVisible(false);
            jualForm.setVisible(true);
            laporanForm.setVisible(false);
            backupForm.setVisible(false);
        } else if (event.getSource() == menuLaporan) {
            homeForm.setVisible(false);
            sampahForm.setVisible(false);
            jualForm.setVisible(false);
            laporanForm.setVisible(true);
            backupForm.setVisible(false);
        } else if (event.getSource() == menuBackup) {
            homeForm.setVisible(false);
            sampahForm.setVisible(false);
            jualForm.setVisible(false);
            laporanForm.setVisible(false);
            backupForm.setVisible(true);
        }
        // Add logic for handling other menu options if needed
    }

    // Deklarasi
    public static ObservableList<DataSampah> dataSampahList = FXCollections.observableArrayList();
    public static ObservableList<DataPenjualan> dataPenjualanList = FXCollections.observableArrayList();

    public MenuController(ObservableList<DataSampah> dataSampahList) {
        MenuController.dataSampahList = dataSampahList;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        MenuController.dataSampahList = XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class);
        MenuController.dataPenjualanList = XML.<DataPenjualan>readXML("data_penjualan.xml", DataPenjualan.class);

        updateTotalIncome();
        updateBarChart();
        updateLineChart();

        // tableview sampah
        colJenisSampah.setCellValueFactory(new PropertyValueFactory<>("jenisSampah"));
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        TV1.setItems(dataSampahList);

        // integrasi ke label JenisSampah Home
        // Buat variabel untuk menyimpan jumlah jenis sampah
        int totalJenisSampah = 0;
        // Buat sebuah HashSet untuk menyimpan jenis sampah yang unik
        Set<String> jenisSampahSet = new HashSet<>();
        // Iterasi melalui dataSampah untuk menghitung jumlah jenis sampah
        for (DataSampah sampah : dataSampahList) {
            jenisSampahSet.add(sampah.getJenisSampah());
        }
        // Menghitung jumlah jenis sampah
        totalJenisSampah = jenisSampahSet.size();
        // Tampilkan jumlah jenis sampah di Label
        JenisSampahHome.setText(String.valueOf(totalJenisSampah));

        // tableview jual
        colTanggalJ.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colPengepulJ.setCellValueFactory(new PropertyValueFactory<>("pengepul"));
        colJumlahJ.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colHargaJ.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colTotalJ.setCellValueFactory(new PropertyValueFactory<>("total"));
        colJenisSampahJ.setCellValueFactory(cellData -> {
            DataPenjualan penjualan = cellData.getValue();
            DataSampah sampah = penjualan.getJenisSampah();
            return new SimpleStringProperty(sampah.getJenisSampah());
        });
        TV11.setItems(dataPenjualanList);

        // Set data ke ComboBox jenisSampahP
        jenisSampahP.setItems(dataSampahList);

        // Add listener to jenisSampahP ComboBox
        jenisSampahP.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                HargaP.setText(String.valueOf(newValue.getHarga()));
                StokP.clear();
                TotalP.setText(String.valueOf(newValue.getTotal()));
            }
        });

        // Add listener to StokP text field
        StokP.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                int jumlah = Integer.parseInt(newValue);
                double harga = Double.parseDouble(HargaP.getText());
                double total = jumlah * harga;
                TotalP.setText(String.valueOf(total));
            }
        });
        // Atur cell factory untuk ComboBox
        jenisSampahP.setCellFactory(param -> new ListCell<DataSampah>() {
            @Override
            protected void updateItem(DataSampah item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getJenisSampah());
                }
            }
        });

        // Atur cell factory untuk dropdown ComboBox
        jenisSampahP.setButtonCell(new ListCell<DataSampah>() {
            @Override
            protected void updateItem(DataSampah item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getJenisSampah());
                }
            }
        });

        // tv3
        colJenisSampahSL.setCellValueFactory(new PropertyValueFactory<>("jenisSampah"));
        colKodeSL.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colHargaSL.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStokSL.setCellValueFactory(new PropertyValueFactory<>("stok"));
        colStatusSL.setCellValueFactory(new PropertyValueFactory<>("status"));
        TV3.setItems(dataSampahList);

        // tv4
        colTanggalJL.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colPengepulJL.setCellValueFactory(new PropertyValueFactory<>("pengepul"));
        colJumlahJL.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colHargaJL.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colTotalJL.setCellValueFactory(new PropertyValueFactory<>("total"));
        colJenisSampahJL.setCellValueFactory(cellData -> {
            DataPenjualan penjualan = cellData.getValue();
            DataSampah sampah = penjualan.getJenisSampah();
            return new SimpleStringProperty(sampah.getJenisSampah());
        });
        TV4.setItems(dataPenjualanList);

        backupDSImage.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                backupDataSampah();
            }
        });

        backupDPImage.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                backupDataPenjualan();
            }
        });

        menuKeluar.setOnMouseClicked(event -> {
            // keluar dari aplikasi
            exitApplication();
        });

    }

    // HOME

    private void updateTotalIncome() {
        double totalIncome = 0.0;

        for (DataPenjualan penjualan : dataPenjualanList) {
            totalIncome += penjualan.getTotal();
        }

        Locale locale = new Locale("id", "ID"); // Menentukan locale sesuai kebutuhan, misalnya "en", "US" untuk format
                                                // Inggris-Amerika
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedTotalIncome = numberFormat.format(totalIncome);

        TotalIncomeHome.setText(formattedTotalIncome);
    }

    private void updateBarChart() {
        barChart.getData().clear();

        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Total Penjualan");

        // Hitung total penjualan untuk setiap jenisSampah
        Map<String, Double> totalSalesByJenisSampah = new HashMap<>();

        for (DataPenjualan penjualan : dataPenjualanList) {
            String jenisSampah = penjualan.getJenisSampah().getJenisSampah();
            double total = penjualan.getTotal();

            if (totalSalesByJenisSampah.containsKey(jenisSampah)) {
                total += totalSalesByJenisSampah.get(jenisSampah);
            }

            totalSalesByJenisSampah.put(jenisSampah, total);
        }

        // buat ObservableList to hold data
        ObservableList<XYChart.Data<String, Double>> chartData = FXCollections.observableArrayList();

        // Add data to chartData list
        for (Map.Entry<String, Double> entry : totalSalesByJenisSampah.entrySet()) {
            String jenisSampah = entry.getKey();
            double total = entry.getValue();
            chartData.add(new XYChart.Data<>(jenisSampah, total));
        }

        // Set the data to series
        series.setData(chartData);

        // Add series to the barchart
        barChart.getData().add(series);
    }

    private void updateLineChart() {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Menghitung total jumlah sampah terjual berdasarkan bulan
        Map<Integer, Integer> totalSoldByMonth = new HashMap<>();
        for (DataPenjualan dataPenjualan : dataPenjualanList) {
            int month = dataPenjualan.getTanggal().getMonthValue();
            int jumlah = dataPenjualan.getJumlah();

            totalSoldByMonth.put(month, totalSoldByMonth.getOrDefault(month, 0) + jumlah);
        }

        // Mengurutkan bulan-bulan secara benar
        List<Integer> sortedMonths = new ArrayList<>(totalSoldByMonth.keySet());
        Collections.sort(sortedMonths);

        // Menambahkan data ke dalam series dengan urutan yang sudah diurutkan
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        for (int month : sortedMonths) {
            String monthName = dfs.getMonths()[month - 1];
            int totalSold = totalSoldByMonth.get(month);
            series.getData().add(new XYChart.Data<>(monthName, totalSold));
        }

        // Menambahkan series ke dalam LineChart
        lineChart.getData().clear();
        lineChart.getData().add(series);
    }

    // SAMPAH

    public TableView<DataSampah> getTV1() {
        return TV1;
    }

    public TableView<DataSampah> getTV3() {
        return TV3;
    }

    @FXML
    void bukaXML1(MouseEvent event) {

    }

    @FXML
    void handleEdit(ActionEvent event) {
        // ngambil objek datasampah ke tableview

        DataSampah selectedDataSampah = TV1.getSelectionModel().getSelectedItem();

        if (selectedDataSampah != null) {
            try {
                // Load edit window
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Update/Tedit.fxml"));
                Parent root = loader.load();

                // Get the EditController instance
                EditController editController = loader.getController();
                // Pass the selected DataSampah object to the EditController
                editController.initData(selectedDataSampah);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleHapus(ActionEvent event) {
        int selectedIndex = TV1.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            MenuController.dataSampahList = FXCollections.observableArrayList();
            MenuController.dataSampahList.addAll(XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class));

            MenuController.dataSampahList.remove(selectedIndex);
            TV1.getItems().remove(selectedIndex);
            XML.writeXML("data_sampah.xml", MenuController.dataSampahList);

            // Update the label JenisSampahHome
            Set<String> jenisSampahSet = new HashSet<>();
            for (DataSampah sampah : dataSampahList) {
                jenisSampahSet.add(sampah.getJenisSampah());
            }
            int totalJenisSampah = jenisSampahSet.size();
            JenisSampahHome.setText(String.valueOf(totalJenisSampah));

            System.out.println("Data removed and saved to XML.");
        }
    }

    @FXML
    void handleReset(ActionEvent event) {
        try {
            MenuController.dataSampahList = FXCollections.observableArrayList();
            MenuController.dataSampahList.addAll(XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class));
            TV1.setItems(dataSampahList);
            XML.writeXML("data_sampah.xml", dataSampahList);
            System.out.println("Data reset and saved to XML.");
        } catch (Exception e) {
            System.err.println("Failed to reset and save data to XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleSearchProduk(ActionEvent event) {
        String searchKeyword = inSearch.getText().toLowerCase();

        // Buat daftar yang difilter untuk menampung hasil pencarian
        ObservableList<DataSampah> filteredList = FXCollections.observableArrayList();

        // pencarian berdasarkan searchKeyword
        for (DataSampah dataSampah : dataSampahList) {
            if (dataSampah.getJenisSampah().toLowerCase().contains(searchKeyword) ||
                    dataSampah.getKode().toLowerCase().contains(searchKeyword)) {
                filteredList.add(dataSampah);
            }
        }

        // set daftar yang difilter sbg item baru untuk TableView sampah
        TV1.setItems(filteredList);
    }

    @FXML
    void handleTambah(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Update/Ttambah.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleSave(ActionEvent event) {

    }

    // Create a static variable to hold the instance
    private static MenuController instance;

    public MenuController() {
        instance = this;
    }

    static URL url;
    static ResourceBundle rb;

    public void addDataSampah(DataSampah dataSampah) {
        MenuController.dataSampahList = FXCollections.observableArrayList();
        MenuController.dataSampahList.addAll(XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class));
        MenuController.dataSampahList.add(dataSampah);
        XML.<DataSampah>writeXML("data_sampah.xml", MenuController.dataSampahList);

        MenuController menuController = MenuController.getInstance();
        menuController.initialize(url, rb);

    }

    // Create a static method to retrieve the instance
    public static MenuController getInstance() {
        return instance;
    }

    // PENJUALAN

    @FXML
    void handleJual(ActionEvent event) {

        System.out.println("Before reading XML");

        // Read XML and deserialize
        MenuController.dataPenjualanList = FXCollections.observableArrayList(); // Deklarasi dan inisialisasi
                                                                                // ObservableList
        MenuController.dataPenjualanList.addAll(XML.<DataPenjualan>readXML("data_penjualan.xml", DataPenjualan.class));
        System.out.println("After reading XML. DataPenjualanList: " + MenuController.dataPenjualanList);

        MenuController.dataSampahList = XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class);

        DataSampah selectedSampah = jenisSampahP.getValue();
        LocalDate tanggal = TglP.getValue();
        String pengepul = pengepulP.getText();
        int jumlah = Integer.parseInt(StokP.getText());
        double harga = Double.parseDouble(HargaP.getText());
        double total = jumlah * harga;

        // Alert
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Konfirmasi");
        confirmationDialog.setHeaderText("Konfirmasi Penjualan");
        confirmationDialog.setContentText("Apakah Anda yakin ingin menjual sampah ini?");

        confirmationDialog.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        ButtonType userChoice = confirmationDialog.showAndWait().orElse(ButtonType.NO);

        if (userChoice == ButtonType.YES) {
            DataPenjualan dataPenjualan = new DataPenjualan(selectedSampah, tanggal, pengepul, jumlah, harga, total);
            MenuController.dataPenjualanList.add(dataPenjualan);

            updateDataSampahStok(selectedSampah, jumlah);

            // Clear input
            jenisSampahP.getSelectionModel().clearSelection();
            TglP.setValue(null);
            pengepulP.clear();
            StokP.clear();
            HargaP.clear();
            TotalP.clear();

            // Memperbarui TableView dengan data terbaru
            TV11.setItems(MenuController.dataPenjualanList);
            TV11.refresh();

            TV4.setItems(MenuController.dataPenjualanList);
            TV4.refresh();

            TV1.setItems(MenuController.dataSampahList);
            TV1.refresh();

            TV3.setItems(MenuController.dataSampahList);
            TV3.refresh();

            XML.<DataPenjualan>writeXML("data_penjualan.xml", MenuController.dataPenjualanList);
            XML.<DataSampah>writeXML("data_sampah.xml", dataSampahList);
        } else {
            // Penjualan dibatalkan
        }

        updateTotalIncome();
        updateBarChart();
        updateLineChart();
    }

    // Metode untuk mengupdate/menambahkan stok di objek DataSampah
    private void updateDataSampahStok(DataSampah selectedSampah, int jumlah) {
        for (DataSampah dataSampah : dataSampahList) {
            if (dataSampah.getJenisSampah().equals(selectedSampah.getJenisSampah())) {
                dataSampah.tambahStok(jumlah);
                break;
            }
        }
    }

    @FXML
    private ImageView backupDSImage;

    @FXML
    private ImageView backupDPImage;

    // BACKUP

    @FXML
    void handleBackupDS(ActionEvent event) {
        backupDataSampah();
    }

    @FXML
    void handleBackupDP(ActionEvent event) {
        backupDataPenjualan();
    }

    private void backupDataSampah() {
        MenuController.dataSampahList = FXCollections.observableArrayList();
        MenuController.dataSampahList.addAll(XML.<DataSampah>readXML("data_sampah.xml", DataSampah.class));
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            XML.writeXML(file.getAbsolutePath(), dataSampahList);
        }
    }

    private void backupDataPenjualan() {
        MenuController.dataPenjualanList = FXCollections.observableArrayList();
        MenuController.dataPenjualanList.addAll(XML.<DataPenjualan>readXML("data_penjualan.xml", DataPenjualan.class));
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            XML.writeXML(file.getAbsolutePath(), dataPenjualanList);
        }
    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML Files", "*.xml"));
        fileChooser.setTitle("Save as XML");
    }

    // KELUAR

    private void exitApplication() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Keluar");
        alert.setHeaderText("Keluar dari Aplikasi");
        alert.setContentText("Apakah Anda yakin ingin keluar?");
        Stage stage = (Stage) homeForm.getScene().getWindow();

        // Menambahkan tombol Yes dan No ke dialog konfirmasi
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Menampilkan dialog konfirmasi
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            stage.close();
        }
    }

}