import java.util.Scanner;

class Mobil {
    String noPlat;
    String merkMobil;
    String warnaMobil;
    int tahunKeluaran;
    String tipeMobil; // Menambahkan atribut tipeMobil

    // Constructor untuk menginisialisasi objek Mobil dengan atribut tambahan tipeMobil
    public Mobil(String noPlat, String merkMobil, String warnaMobil, int tahunKeluaran, String tipeMobil) {
        this.noPlat = noPlat;
        this.merkMobil = merkMobil;
        this.warnaMobil = warnaMobil;
        this.tahunKeluaran = tahunKeluaran;
        this.tipeMobil = tipeMobil;
    }

    // Metode untuk mengembalikan representasi string dari objek Mobil dalam format tabel
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10d %-10s", noPlat, merkMobil, warnaMobil, tahunKeluaran, tipeMobil);
    }
}

public class dataMobil {
    private static Mobil[] daftarMobil = new Mobil[2]; // Memulai dengan ukuran array kecil untuk daftar mobil
    private static int jumlahMobil = 0; // Menyimpan jumlah mobil yang telah ditambahkan
    private static Scanner sc = new Scanner(System.in); // Membuat objek Scanner untuk membaca input

    public static void main(String[] args) {
        while (true) {
            // Menampilkan menu utama
            System.out.printf("%n%-5s %s%n", "", "========== Menu ==========");
            System.out.printf("%-5s %-3s %s%n", "", "1.", "Input Data Mobil");
            System.out.printf("%-5s %-3s %s%n", "", "2.", "Lihat Semua Data Mobil");
            System.out.printf("%-5s %-3s %s%n", "", "3.", "Cari Data Mobil Berdasarkan Atribut");
            System.out.printf("%-5s %-3s %s%n", "", "4.", "Keluar");
            System.out.printf("%-5s %s", "", "Pilih opsi: ");
            
            // Membaca opsi pilihan pengguna
            int opsi = sc.nextInt();
            sc.nextLine(); // Mengonsumsi newline agar tidak terjadi masalah saat membaca input berikutnya

            // Menjalankan fungsi berdasarkan pilihan pengguna
            switch (opsi) {
                case 1:
                    inputDataMobil();
                    break;
                case 2:
                    tampilkanSemuaMobil();
                    break;
                case 3:
                    cariMobil();
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    return; // Keluar dari program
                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }

    // Fungsi untuk memasukkan data mobil
    public static void inputDataMobil() {
        // Mengecek apakah array penuh, jika ya maka memperluas array
        if (jumlahMobil >= daftarMobil.length) {
            perluasArray();
        }

        // Membaca data mobil dari pengguna
        System.out.println("Masukkan data mobil dalam format: NoPlat,MerkMobil,WarnaMobil,TahunKeluaran,TipeMobil");
        System.out.print("Contoh: B1234XYZ,Toyota,Putih,2021,SUV\nInput: ");
        String input = sc.nextLine();

        // Memisahkan input berdasarkan koma dan mengasumsikan formatnya benar
        String[] data = input.split(",");
        if (data.length == 5) {
            String noPlat = data[0];
            String merkMobil = data[1];
            String warnaMobil = data[2];
            int tahunKeluaran = Integer.parseInt(data[3]); // Mengonversi tahun keluaran menjadi integer tanpa pengecekan
            String tipeMobil = data[4];
            daftarMobil[jumlahMobil] = new Mobil(noPlat, merkMobil, warnaMobil, tahunKeluaran, tipeMobil); // Menambahkan mobil ke array
            jumlahMobil++; // Meningkatkan jumlah mobil yang tercatat
            System.out.println("Data mobil berhasil ditambahkan.");
        } else {
            System.out.println("Format input salah. Pastikan menggunakan format yang benar.");
        }
    }

    // Fungsi untuk memperbesar kapasitas array ketika penuh
    public static void perluasArray() {
        Mobil[] daftarBaru = new Mobil[daftarMobil.length * 2]; // Menggandakan ukuran array
        for (int i = 0; i < daftarMobil.length; i++) {
            daftarBaru[i] = daftarMobil[i]; // Menyalin data dari array lama ke array baru
        }
        daftarMobil = daftarBaru; // Menggantikan array lama dengan array baru yang lebih besar
        System.out.println("Kapasitas array diperbesar menjadi " + daftarMobil.length);
    }

    // Fungsi untuk menampilkan semua data mobil dalam format tabel
    public static void tampilkanSemuaMobil() {
        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun", "Tipe");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < jumlahMobil; i++) {
            System.out.println(daftarMobil[i]); // Menampilkan setiap mobil
        }
    }

    // Fungsi untuk mencari mobil berdasarkan nilai tertentu (dapat berupa noPlat, merkMobil, warnaMobil, tahunKeluaran, atau tipeMobil)
    public static void cariMobil() {
        System.out.print("Masukkan nilai untuk pencarian: ");
        String nilai = sc.nextLine(); // Membaca nilai yang akan dicari

        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun", "Tipe");
        System.out.println("--------------------------------------------------------------");

        boolean ditemukan = false; // Menyimpan apakah ada mobil yang cocok dengan pencarian
        for (int i = 0; i < jumlahMobil; i++) {
            if (cocokkanAtribut(daftarMobil[i], nilai)) { // Mengecek apakah mobil cocok dengan nilai pencarian
                System.out.println(daftarMobil[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada mobil yang sesuai dengan pencarian.");
        }
    }

    // Fungsi untuk mengecek apakah atribut mobil cocok dengan nilai pencarian
    public static boolean cocokkanAtribut(Mobil mobil, String nilai) {
        // Mengecek apakah nilai cocok dengan salah satu atribut mobil
        return mobil.noPlat.equalsIgnoreCase(nilai) ||
               mobil.merkMobil.equalsIgnoreCase(nilai) ||
               mobil.warnaMobil.equalsIgnoreCase(nilai) ||
               String.valueOf(mobil.tahunKeluaran).equals(nilai) ||
               mobil.tipeMobil.equalsIgnoreCase(nilai);
    }
}
