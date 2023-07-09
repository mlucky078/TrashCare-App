package Menu;

import java.time.LocalDate;

public class DataLaporan {
   private LocalDate tglL;
    private String kodeL;
    private String pengepulL;
    private String jenisSampahL;
    private Double hargaL;
    private Integer stokL;
    private Double totalL;

    public DataLaporan(LocalDate tglL, String kodeL, String pengepulL, String jenisSampahL, Double hargaL, Integer stokL, Double totalL) {
        this.tglL = tglL;
        this.kodeL = kodeL;
        this.pengepulL = pengepulL;
        this.jenisSampahL = jenisSampahL;
        this.hargaL = hargaL;
        this.stokL = stokL;
        this.totalL = totalL;
    }

    public LocalDate getTglL() {
        return tglL;
    }

    public void setTglL(LocalDate tglL) {
        this.tglL = tglL;
    }

    public String getKodeL() {
        return kodeL;
    }

    public void setKodeL(String kodeL) {
        this.kodeL = kodeL;
    }

    public String getPengepulL() {
        return pengepulL;
    }

    public void setPengepulL(String pengepulL) {
        this.pengepulL = pengepulL;
    }

    public String getJenisSampahL() {
        return jenisSampahL;
    }

    public void setJenisSampahL(String jenisSampahL) {
        this.jenisSampahL = jenisSampahL;
    }

    public Double getHargaL() {
        return hargaL;
    }

    public void setHargaL(Double hargaL) {
        this.hargaL = hargaL;
    }

    public Integer getStokL() {
        return stokL;
    }

    public void setStokL(Integer stokL) {
        this.stokL = stokL;
    }

    public Double getTotalL() {
        return totalL;
    }

    public void setTotalL(Double totalL) {
        this.totalL = totalL;
    }
}
