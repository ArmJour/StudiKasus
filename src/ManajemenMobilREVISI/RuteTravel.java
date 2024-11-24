package ManajemenMobil;

class RuteTravel {
    private String asal;
    private String tujuan;
    private int biaya;

    // Konstruktor
    public RuteTravel(String asal, String tujuan, int biaya) {
        this.asal = asal;
        this.tujuan = tujuan;
        this.biaya = biaya;
    }

    // Getter
    public String getAsal() {
        return asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public int getBiaya() {
        return biaya;
    }

    // Method untuk mencetak data rute
    public void tampilkanRute(int nomor) {
        System.out.printf("%d. %-15s %-10s Rp%-10d\n", nomor, asal, tujuan, biaya);
    }
}
