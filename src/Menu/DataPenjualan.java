package Menu;

import java.time.LocalDate;

public class DataPenjualan {

    private DataSampah jenisSampah;
    private LocalDate tanggal;
    private String pengepul;
    private int jumlah;
    private double harga;
    private double total;

    public DataPenjualan(DataSampah jenisSampah, LocalDate tanggal, String pengepul, int jumlah, double harga, double total) {
        this.jenisSampah = jenisSampah;
        this.tanggal = tanggal;
        this.pengepul = pengepul;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = total;
    }

    public DataPenjualan(LocalDate now, String string, double d, double e) {
    }

    public DataSampah getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(DataSampah jenisSampah) {
        this.jenisSampah = jenisSampah;
    }
    

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getPengepul() {
        return pengepul;
    }

    public void setPengepul(String pengepul) {
        this.pengepul = pengepul;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
}

    
}

