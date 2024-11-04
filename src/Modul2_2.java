package pkgif.elsepratikumsoal;

import java.util.Scanner;

public class dataMobil {
    public static String[][] daftarMobil = new String[2][4]; // Array untuk menyimpan data mobil
    public static int jumlahMobil = 0; // Menyimpan jumlah mobil yang telah ditambahkan
    public static Scanner sc = new Scanner(System.in); // Membuat objek Scanner untuk membaca input

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
        System.out.println("Masukkan data mobil dalam format: NoPlat,MerkMobil,WarnaMobil,TahunKeluaran");
        System.out.print("Contoh: B1234XYZ,Toyota,Putih,2021\nInput: ");
        String input = sc.nextLine();

        // Memisahkan input berdasarkan koma dan mengasumsikan formatnya benar
        String[] data = input.split(",");
        if (data.length == 4) {
            daftarMobil[jumlahMobil][0] = data[0]; // noPlat
            daftarMobil[jumlahMobil][1] = data[1]; // merkMobil
            daftarMobil[jumlahMobil][2] = data[2]; // warnaMobil
            daftarMobil[jumlahMobil][3] = data[3]; // tahunKeluaran
            jumlahMobil++; // Meningkatkan jumlah mobil yang tercatat
            System.out.println("Data mobil berhasil ditambahkan.");
        } else {
            System.out.println("Format input salah. Pastikan menggunakan format yang benar.");
        }
    }

    // Fungsi untuk memperbesar kapasitas array ketika penuh
    public static void perluasArray() {
        String[][] daftarBaru = new String[daftarMobil.length * 2][4]; // Menggandakan ukuran array
        for (int i = 0; i < daftarMobil.length; i++) {
            System.arraycopy(daftarMobil[i], 0, daftarBaru[i], 0, 4); // Menyalin data dari array lama ke array baru
        }
        daftarMobil = daftarBaru; // Menggantikan array lama dengan array baru yang lebih besar
        System.out.println("Kapasitas array diperbesar menjadi " + daftarMobil.length);
    }

    // Fungsi untuk menampilkan semua data mobil dalam format tabel
    public static void tampilkanSemuaMobil() {
        System.out.printf("%-10s %-15s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < jumlahMobil; i++) {
            System.out.printf("%-10s %-15s %-10s %-10s\n", daftarMobil[i][0], daftarMobil[i][1], daftarMobil[i][2], daftarMobil[i][3]);
        }
    }

    // Fungsi untuk mencari mobil berdasarkan nilai tertentu (dapat berupa noPlat, merkMobil, warnaMobil, atau tahunKeluaran)
    public static void cariMobil() {
        System.out.print("Masukkan nilai untuk pencarian: ");
        String nilai = sc.nextLine(); // Membaca nilai yang akan dicari

        System.out.printf("%-10s %-15s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun");
        System.out.println("--------------------------------------------------------");

        boolean ditemukan = false; // Menyimpan apakah ada mobil yang cocok dengan pencarian
        for (int i = 0; i < jumlahMobil; i++) {
            if (cocokkanAtribut(daftarMobil[i], nilai)) { // Mengecek apakah mobil cocok dengan nilai pencarian
                System.out.printf("%-10s %-15s %-10s %-10s\n", daftarMobil[i][0], daftarMobil[i][1], daftarMobil[i][2], daftarMobil[i][3]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada mobil yang sesuai dengan pencarian.");
        }
    }

    // Fungsi untuk mengecek apakah atribut mobil cocok dengan nilai pencarian
    public static boolean cocokkanAtribut(String[] mobil, String nilai) {
        // Mengecek apakah nilai cocok dengan salah satu atribut mobil
        return mobil[0].equalsIgnoreCase(nilai) || // noPlat
               mobil[1].equalsIgnoreCase(nilai) || // merkMobil
               mobil[2].equalsIgnoreCase(nilai) || // warnaMobil
               mobil[3].equals(nilai); // tahunKeluaran
    }
}

