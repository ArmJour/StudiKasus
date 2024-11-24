package ManajemenMobil;

import java.util.Scanner;

public class ManajerTravel {
    static Scanner sc = new Scanner (System.in);
    
    public static void manajerTravel() {
        // Membuat objek rute travel
        RuteTravel[] ruteList = {
            new RuteTravel("Surabaya", "Malang", 100000),
            new RuteTravel("Madura", "Malang", 200000),
            new RuteTravel("Banyuwangi", "Malang", 250000),
            new RuteTravel("Situbondo", "Malang", 175000),
            new RuteTravel("Tulungagung", "Malang", 125000)
        };

        // Menampilkan menu rute travel
        System.out.println("Silahkan pilih rute travel: ");
        System.out.printf("================= Menu =================\n");
        System.out.printf("    %-15s %-12s %-10s\n", "asal", "tujuan", "biaya");
        
        for (int i = 0; i < ruteList.length; i++) {
            ruteList[i].tampilkanRute(i + 1);
        }

        System.out.printf("========================================\n");

        // Meminta input pengguna untuk memilih rute
        System.out.print("Masukkan nomor rute yang anda pilih: ");
        int rute = sc.nextInt();
        sc.nextLine();

        // Memproses pilihan rute dan menghitung biaya
        int biayaTravel = 0;
        if (rute > 0 && rute <= ruteList.length) {
            biayaTravel = ruteList[rute - 1].getBiaya();
        } else {
            System.out.println("Nomor rute yang anda masukkan tidak valid.");
            return;
        }

        // Menampilkan tagihan
        System.out.printf("Terimakasih sudah menggunakan jasa kami, total tagihan anda Rp%d\n", biayaTravel);
        System.out.println("");
    }
}

