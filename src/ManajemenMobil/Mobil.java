package ManajemenMobil;

public class Mobil {

    private String noPlat;
    private String merkMobil;
    private String warnaMobil;
    private int tahunKeluaran;

    public Mobil(String noPlat, String merkMobil, String warnaMobil, int tahunKeluaran){
        this.noPlat = noPlat;
        this.merkMobil = merkMobil;
        this.warnaMobil = warnaMobil;
        this.tahunKeluaran = tahunKeluaran;
    }

    public String getNoPlat() {
        return noPlat;
    }
    public String getMerkMobil() {
        return merkMobil;
    }
    public String getWarnaMobil() {
        return warnaMobil;
    }
    public int getTahunKeluaran() {
        return tahunKeluaran;
    }

}
