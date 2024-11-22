package ManajemenKaryawan;

/*Muhammad Raditya Arsyad | 245150207111043 | Semester 1 | Pemrograman Dasar Kelas C*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManajerKaryawan manajer = new ManajerKaryawan();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("1. Input Data Karyawan");
            System.out.println("2. Tampilkan Data Karyawan");
            System.out.println("3. Input Gaji Karyawan");
            System.out.println("4. Tampil Gaji Karyawan");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> manajer.inputKaryawan(sc);
                case 2 -> manajer.tampilKaryawan();
                case 3 -> manajer.inputUntukGaji(sc);
                case 4 -> manajer.tampilGajiKaryawan();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}
