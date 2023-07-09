package Menu;


public class DataSampah {
    private String kode;
    private String jenisSampah;
    private double harga;
    private int stok;
    private String status;
     private String tanggal; // New property for date
     private String pengepul;
    private int jumlah; // New property for jumlah
    private int total; // New property for total




    public DataSampah(String kode, String jenisSampah, double harga, int stok, String status) {
        this.kode = kode;
        this.jenisSampah = jenisSampah;
        this.harga = harga;
        this.stok = stok;
        this.status = status;
    }

    public String toString(){
        return this.kode + " " + this.jenisSampah + " " + this.harga + " " + this.stok + " " + this.status;
    }

   

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

      public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

   

}