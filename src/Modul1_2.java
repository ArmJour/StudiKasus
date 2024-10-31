import java.util.Scanner;

public class Modul1_2 {

    public String nama;
    public String alamat;
    public long noTelp;
    public String JenisKelamin;
    public int umur;
    public String kategoriKaryawan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("MASUKKAN JUMLAH KARYAWAN YANG INGIN DIDATA: ");
        int n = sc.nextInt(); sc.nextLine(); // Input jumlah karyawan yang ingin dimasukkan datanya
        String[] biodata; // Deklarasi array untuk biodata karyawan

        Modul1_2[] ArrayKaryawan = new Modul1_2[n];

        System.out.println("INPUT DENGAN FORMAT [NAMA] [ALAMAT] [NO TELP] [JENIS KELAMIN] [UMUR] [Kategori Karyawan]");
        for (int i = 0; i < n ; i++) {
            String input = sc.nextLine(); // Imput biodata dalam 1 baris
            biodata = input.split(" "); // Memisah input dari 1 string menjadi elemen array yang dipisahkan dengan spasi

            // Memasukkan elemen masing2 data pada biodata kedalam variabel yang ditentukan.
            String nama = biodata[0];
            String alamat = biodata[1];
            long noTelp = Long.parseLong(biodata[2]);
            String jenisKelamin = biodata[3];
            int umur = Integer.parseInt(biodata[4]);
            String kategoriKaryawan = biodata[5];

            // Membuat objek karyawan dan mengisi data menggunakan method dataKaryawan
            ArrayKaryawan[i] =new Modul1_2();
            ArrayKaryawan[i].datakaryawan(nama, alamat, noTelp, jenisKelamin, umur, kategoriKaryawan);
        }

        // Memberi output biodata karyawan setelah semua karyawan telah diinputkan datanya.
        System.out.println("\nDATA KARYAWAN:");
        for (int i = 0; i < ArrayKaryawan.length; i++) {
            System.out.println("Nama: " + ArrayKaryawan[i].nama);
            System.out.println("Alamat: " + ArrayKaryawan[i].alamat);
            System.out.println("No Telp: " + ArrayKaryawan[i].noTelp);
            System.out.println("Jenis kelamin: " + ArrayKaryawan[i].JenisKelamin);
            System.out.println("Umur: " + ArrayKaryawan[i].umur);
            System.out.println("Kategori Karyawan: " + ArrayKaryawan[i].kategoriKaryawan);
            System.out.println();
        }
    }

    // Method untuk mengatur mendetail biodata yang memuat nama, alamat, no telp, jenis kelamin, umur, dan kategori karyawan.
    public void datakaryawan(String name, String alamat, long noTelp, String JenisKelamin, int umur, String kategoriKaryawan) {

        this.nama = name;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.JenisKelamin = JenisKelamin;
        this.umur = umur;
        this.kategoriKaryawan = kategoriKaryawan;

    }
}