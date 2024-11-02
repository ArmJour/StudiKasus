import java.util.Scanner;

public class GajiKaryawan {

    // Data gaji pokok, uang lembur, dan pajak berdasarkan kategori
    static String[] kategori = {"Supir travel", "Supir rentcar", "Admin"};
    static double[] gajiPokok = {1500000, 1750000, 2000000};
    static double[] uangLembur = {50000, 45000, 40000};
    static double[] pajak = {0.05, 0.06, 0.07};

    // Fungsi untuk menghitung gaji bersih karyawan
    public static double hitungGajiBersih(int kategoriIndex, int jamLembur) {
        double gajiKotor = gajiPokok[kategoriIndex] + (jamLembur * uangLembur[kategoriIndex]);
        double gajiBersih = gajiKotor - (gajiKotor * pajak[kategoriIndex]);
        return gajiBersih;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menampilkan pilihan kategori
        System.out.println("Pilih kategori karyawan:");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        
        // Meminta input kategori karyawan
        System.out.print("Masukkan nomor kategori (1-3): ");
        int kategoriIndex = input.nextInt() - 1;

        // Validasi input kategori
        if (kategoriIndex < 0 || kategoriIndex >= kategori.length) {
            System.out.println("Kategori tidak valid.");
            return;
        }

        // Meminta input jam lembur
        System.out.print("\nMasukkan jumlah jam lembur: ");
        int jamLembur = input.nextInt();

        // Menghitung gaji bersih
        double gajiBersih = hitungGajiBersih(kategoriIndex, jamLembur);

        // Menampilkan hasil
        System.out.printf("\nGaji bersih karyawan: Rp %.2f%n", gajiBersih);
        
        input.close();
    }
}
