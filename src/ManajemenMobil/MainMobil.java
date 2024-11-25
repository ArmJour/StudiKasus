package ManajemenMobil;

import java.util.Scanner;

public class MainMobil {
    private static Scanner sc = new Scanner(System.in);
    private static ManajerMobil manajerMobil = new ManajerMobil();
    private static ManajerTravel manajerTravel = new ManajerTravel();
    private static int jumlahMobil = 0;

public static void main(String[] args) {
        boolean sudahInputMobil = false;
        String sudahSelesai = "ya";

        while (sudahSelesai.equalsIgnoreCase("ya")) {
            System.out.println("Selamat datang di aplikasi kami, Anda ingin masuk sebagai admin atau konsumen?");
            System.out.print("Jawab dengan mengetik \"admin\" atau \"konsumen\": ");
            String statusUser = sc.nextLine();
            System.out.println();

            if (statusUser.equalsIgnoreCase("admin")) {
                menuAdmin();
            } else if (statusUser.equalsIgnoreCase("konsumen")) {
                menuKonsumen();
            } else {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }

            System.out.print("Apakah Anda masih ingin menggunakan aplikasi? (ya/tidak): ");
            sudahSelesai = sc.nextLine();
            System.out.println();
        }
    }

    private static void menuAdmin() {
        int opsi = 0;
        while (opsi != 4) {
            System.out.println("========== Menu Admin ==========");
            System.out.println("1. Input Data Mobil");
            System.out.println("2. Lihat Semua Data Mobil");
            System.out.println("3. Cari Data Mobil");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            opsi = sc.nextInt();
            sc.nextLine();

            switch (opsi) {
                case 1 -> {
                    manajerMobil.inputDataMobil();
                    jumlahMobil = manajerMobil.getJumlahMobil();
                }
                case 2 -> manajerMobil.tampilSemuaMobil();
                case 3 -> {
                    manajerMobil.cariMobil();
                }
                case 4 -> System.out.println("Protokol admin selesai.");
                default -> System.out.println("Opsi tidak valid. Coba lagi.");
            }
            System.out.println("");
        }
    }

    private static void menuKonsumen() {
        System.out.println("Apakah Anda ingin menggunakan jasa travel atau sewa?");
        System.out.print("Jawab dengan mengetik \"travel\" atau \"sewa\": ");
        String jenisJasa = sc.nextLine();
        System.out.println();

        if (jenisJasa.equalsIgnoreCase("travel")) {
            ManajerTravel.manajerTravel();
        } else if (jenisJasa.equalsIgnoreCase("sewa")) {
            if (jumlahMobil == 0) {
                System.out.println("Tidak ada mobil yang tersedia.\n");
            } else {
                manajerMobil.tampilSemuaMobil();
                System.out.print("Masukkan plat nomor mobil yang Anda pilih: ");
                String noPlatPilihan = sc.nextLine();
                
                boolean ditemukan = false;
                if (manajerMobil.cekNoPlatMobil(noPlatPilihan)){
                    ditemukan = true;
                }
                
                System.out.print("Masukkan lama jam sewa: ");
                int jamSewa = sc.nextInt();
                sc.nextLine();
                
                if (!ditemukan) {
                    System.out.println("Mobil dengan plat nomor tersebut tidak ditemukan.\n");
                } else {
                    int totalBiaya = jamSewa < 5 ? 500000 : 600000;
                    System.out.printf("Total tagihan Anda adalah Rp%d\n", totalBiaya);
                }
                System.out.println("");
            }
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
        }
    }
}