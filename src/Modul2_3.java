/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
public class Modul2_3 {
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.print("Masukkan lama jam: ");
        int jamSewa = sc.nextInt();
        sc.nextLine();// seleksi kondisi berdasarkan lama penyewaan mobil
        if (jamSewa<5 && jamSewa>0){ //
            System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 400000, 100000, 500000);
        } else {
            System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 450000, 150000, 600000);
        }
    }
}
