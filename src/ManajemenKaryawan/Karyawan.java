package ManajemenKaryawan;

public class Karyawan {
    
    private String nama;
    private String alamat;
    private long noTelp;
    private String email;
    private char jenisKelamin;
    private int umur;
    private String kategoriKaryawan;

    //Constructor
    public Karyawan(String nama, String alamat, String email, long noTelp, char jenisKelamin, int umur, String kategoriKaryawan) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
        this.kategoriKaryawan = kategoriKaryawan;
    }

    public String getNama() {return nama;}

    public String getAlamat() {return alamat;}

    public String getEmail() {return email;}
    
    public long getNoTelp() {return noTelp;}

    public char getJenisKelamin() {return jenisKelamin;}

    public int getUmur() {return umur;}

    public String getKategoriKaryawan() {return kategoriKaryawan;}



 
}
