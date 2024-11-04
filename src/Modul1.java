
import java.util.Scanner;

public class Modul1 {

    /*Gabungan dari Modul1_2 dan Modul1_3*/

    public String nama;
    public String alamat;
    public long noTelp;
    public String email;
    public String JenisKelamin;
    public int umur;
    public String kategoriKaryawan;

    // Data gaji pokok, uang lembur, dan pajak berdasarkan kategori
    static String[] kategori = {"Supir travel", "Supir rentcar", "Admin"};
    static double[] gajiPokok = {1500000, 1750000, 2000000};
    static double[] uangLembur = {50000, 45000, 40000};
    static double[] pajak = {0.05, 0.06, 0.07};

    // Array untuk menyimpan karyawan
    static Modul1[] employees = new Modul1[2];
    static int employeeCount = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        while (m != 4) {
            System.out.print("1. Input data karyawan\n2. Tampilkan list karyawan\n3. Menghitung jumlah gaji dari para karyawan\n4. Keluar\n\nMasukkan angka: ");
            m = sc.nextInt();
            switch (m) {
                case 1 -> {
                    System.out.print("MASUKKAN JUMLAH KARYAWAN YANG INGIN DIDATA: ");
                    int n = sc.nextInt(); sc.nextLine(); // Input jumlah karyawan yang ingin dimasukkan datanya
                    for (int i = 0; i < n; i++) {
                        Modul1 karyawan = new Modul1();

                        System.out.print("Nama: ");
                        karyawan.nama = sc.nextLine();

                        System.out.print("Alamat: ");
                        karyawan.alamat = sc.nextLine();

                        System.out.print("Email: ");
                        karyawan.email = sc.nextLine();

                        System.out.print("No Telp: ");
                        karyawan.noTelp = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Jenis kelamin: ");
                        karyawan.JenisKelamin = sc.nextLine();

                        System.out.print("Umur: ");
                        karyawan.umur = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Kategori Karyawan: ");
                        karyawan.kategoriKaryawan = sc.nextLine();

                        nambahKaryawan(karyawan);

                        System.out.println();
                    }
                }
                case 2 -> {
                    if (employeeCount == 0) {
                        System.out.println("\nTidak ada data karyawan yang tersimpan.");
                    } else {
                        System.out.println("\nDATA KARYAWAN:");
                        System.out.printf("%-15s %-25s %-20s %-15s %-15s %-5s %-15s%n", "Nama", "Alamat","Email", "No Telp", "Jenis Kelamin", "Umur", "Kategori");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        for (int i = 0; i < employeeCount; i++) {
                            Modul1 karyawan = employees[i];
                            System.out.printf("%-15s %-25s %-20s 0%-15d %-15s %-5d %-15s%n",
                                    karyawan.nama, karyawan.alamat,karyawan.email, karyawan.noTelp, karyawan.JenisKelamin, karyawan.umur, karyawan.kategoriKaryawan);
                        }
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Pilih kategori karyawan:");
                    for (int i = 0; i < kategori.length; i++) {
                        System.out.println((i + 1) + ". " + kategori[i]);
                    }

                    // Meminta input kategori karyawan
                    System.out.print("Masukkan nomor kategori (1-3): ");
                    int kategoriIndex = sc.nextInt() - 1;

                    // Validasi input kategori
                    if (kategoriIndex < 0 || kategoriIndex >= kategori.length) {
                        System.out.println("Kategori tidak valid.");
                        return;
                    }

                    // Meminta input jam lembur
                    System.out.print("Masukkan jumlah jam lembur: ");
                    int jamLembur = sc.nextInt();

                    // Menghitung gaji bersih
                    double gajiBersih = hitungGajiBersih(kategoriIndex, jamLembur);

                    // Menampilkan hasil
                    System.out.printf("Gaji bersih karyawan: Rp %.2f%n", gajiBersih);

                    sc.close();
                }
                case 4 -> System.out.println("Goodbye!");
            }
        }
    }

    // Method untuk mengatur mendetail biodata yang memuat nama, alamat, no telp, jenis kelamin, umur, dan kategori karyawan.
    public void datakaryawan(String name, String alamat, long noTelp, String email, String JenisKelamin, int umur, String kategoriKaryawan) {

        this.nama = name;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.JenisKelamin = JenisKelamin;
        this.umur = umur;
        this.kategoriKaryawan = kategoriKaryawan;

    }

    public static void nambahKaryawan(Modul1 karyawan) {
        if(employeeCount == employees.length) {
            Modul1[] karyawanBaru = new Modul1[employees.length * 2];
            System.arraycopy(employees,0, karyawanBaru,0,employees.length);
            employees = karyawanBaru;
        }
        employees[employeeCount++] = karyawan;
    }

    // Fungsi untuk menghitung gaji bersih karyawan
    public static double hitungGajiBersih(int kategoriIndex, int jamLembur) {
        double gajiKotor = gajiPokok[kategoriIndex] + (jamLembur * uangLembur[kategoriIndex]);
        double gajiBersih = gajiKotor - (gajiKotor * pajak[kategoriIndex]);
        return gajiBersih;
    }
}
