package ManajemenKaryawan;

public class Karyawan {
    
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private char jenisKelamin;
    private int umur;
    private String kategoriKaryawan;
    private double gaji;

    //Constructor
    public Karyawan(String nama, String alamat, String email, String noTelp, char jenisKelamin, int umur, String kategoriKaryawan) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
        this.kategoriKaryawan = kategoriKaryawan;
    }

    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public String getEmail(){
        return email;
    }
    
    public String getNoTelp(){
        return noTelp;
    }

    public char getJenisKelamin(){
        return jenisKelamin;
    }

    public int getUmur() {
        return umur;
    }

    public String getKategoriKaryawan(){
        return kategoriKaryawan;
    }

    public double getGaji(){
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }



 
}
