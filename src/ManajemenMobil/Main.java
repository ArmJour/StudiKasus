package ManajemenMobil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManajerMobil manajerMobil = new ManajerMobil();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n========== Menu ==========");
            System.out.println("1. Input Data Mobil");
            System.out.println("2. Lihat Semua Data Mobil");
            System.out.println("3. Cari Data Mobil Berdasarkan Atribut");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (opsi) {
                case 1:
                    manajerMobil.inputDataMobil();
                    break;
                case 2:
                    manajerMobil.tampilSemuaMobil();
                    break;
                case 3:
                    manajerMobil.cariMobil();
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }
}
