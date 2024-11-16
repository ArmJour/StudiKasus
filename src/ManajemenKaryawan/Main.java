package ManajemenKaryawan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManajerKaryawan manajer = new ManajerKaryawan();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Tampilkan Data Karyawan");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> manajer.inputKaryawan(sc);
                case 2 -> manajer.tampilKaryawan();
                case 3 -> System.out.println("Keluar...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}
