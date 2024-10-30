import java.util.Scanner;

public class Modul1_2 {

    public String nama;
    public String alamat;
    public long noTelp;
    public int umur;
    public String kategoriKaryawan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MASUKKAN JUMLAH KARYAWAN YANG INGIN DIDATA: ");
        int n = sc.nextInt(); sc.nextLine();
        String[] biodata;
        System.out.println("INPUT DENGAN FORMAT [NAMA] [ALAMAT] [NO TELP] [JENIS KELAMIN] [UMUR] [Kategori Karyawan]");
        for (int i = 0; i < n ; i++) {
            String input = sc.nextLine();
            biodata = input.split(" ");
            for (int j = 0; j < 5; j++) {
                System.out.print(biodata[j] + " ");
            }
        }
    }

    public void karyawan(String name, String alamat, long noTelp, int umur, String kategoriKaryawan) {

        this.nama = name;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.umur = umur;
        this.kategoriKaryawan = kategoriKaryawan;
    }
}