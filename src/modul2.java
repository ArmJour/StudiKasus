/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemdaskelasc;

/**
 *
 * @author ASUS
 */

import java.util.Scanner;

public class modul2 {
    public static String[][] daftarMobil = new String[2][4]; // Array untuk menyimpan data mobil
    public static int jumlahMobil = 0; // Menyimpan jumlah mobil yang telah ditambahkan
    public static Scanner sc = new Scanner(System.in); // Membuat objek Scanner untuk membaca input

    public static void main(String[] args) {
        
        
        
        String sudahSelesai = "tidak";
        boolean sudahInputMobil=false;
        
        while (sudahSelesai.equalsIgnoreCase("tidak")){
            int opsi = 0;
            
            //pengguna diminta mengkonfirmasi apakah dia adalah admin aplikasi atau konsumen
            System.out.println("Selamat datang di applikasi kami, anda ingin masuk sebagai admin atau konsumen?");
            System.out.println("jawab dengan mengetik \"admin\" atau \"konsumen\"");
            String statusUser = sc.nextLine();
            
            //jika user memilih konsumen maka ia bisa memilih ingin memesan jasa travel atau persewaan mobil
            if (statusUser.equalsIgnoreCase("konsumen")){

                //pengguna diminta memilih ingin menggunakkan jasa travel atau sewa
                System.out.println("Apakah anda ingin menggunakan jasa travel atau sewa?");
                System.out.println("jawab dengan mengetikkan \"travel\" atau \"sewa\"");
                String jenisJasa = sc.nextLine();

                // jika pengguna memilih sewa maka program akan menampilkan mobil yang tersedia dan meminta pengguna memasukkan berapa lama ia akan menyewanya
                if (jenisJasa.equalsIgnoreCase("sewa")){
                    if (sudahInputMobil==false){ // jika admin belum memasukkan mobil yang bisa disewakan maka program akan menampilkan exception ke konsumen
                        System.out.println("Tidak ada mobil yang tersedia :(");
                    } else {
                        tampilkanSemuaMobil();
                        System.out.print("Masukkan plat nomor mobil yang anda pilih: ");
                        String noPlatPilihan = sc.nextLine();
                        System.out.print("Masukkan lama jam: ");
                        int jamSewa = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < jumlahMobil; i++) {
                            if (cocokkanAtribut(daftarMobil[i], noPlatPilihan)) { // Mengecek apakah mobil cocok dengan nilai pencarian
                                System.out.printf("%-10s %-15s %-10s %-10s\n", daftarMobil[i][0], daftarMobil[i][1], daftarMobil[i][2], daftarMobil[i][3]);
                            }
                        }
                        System.out.println("Terimakasih sudah menggunakan jasa kami, berikut pesanan anda:");
                        if (jamSewa<5 && jamSewa>0){ //seleksi kondisi berdasarkan lama penyewaan mobil
                            System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 400000, 100000, 500000);
                        } else {
                            System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 450000, 150000, 600000);
                        }
                    }


                // jika pengguna memilih travel maka program akan menampilkan menu rute travel yang disediakan
                } else if (jenisJasa.equalsIgnoreCase("travel")){

                    //mencetak menu rute travel
                    System.out.println("Silahkan pilih rute travel: ");
                    System.out.printf("================= Menu =================\n");
                    System.out.printf("    %-15s %-12s %-12s\n","asal","tujuan","biaya");
                    System.out.printf("1. %-15s %-10s Rp%-10d\n","Surabaya","Malang",100000);
                    System.out.printf("2. %-15s %-10s Rp%-10d\n","Madura","Malang",200000);
                    System.out.printf("3. %-15s %-10s Rp%-10d\n","Banyuwangi","Malang",250000);
                    System.out.printf("4. %-15s %-10s Rp%-10d\n","Situbondo","Malang",175000);
                    System.out.printf("5. %-15s %-10s Rp%-10d\n","Tulungagung","Malang",125000);
                    System.out.printf("========================================\n");

                    //pengguna diminta memasukkan nomor rute yang dia pilih untuk menentukan besar biaya
                    int biayaTravel=0;
                    System.out.println("Masukkan nomor rute yang anda pilih");
                    int rute = sc.nextInt();
                    sc.nextLine():
                    switch (rute){
                        case 1 -> biayaTravel=100000;
                        case 2 -> biayaTravel=200000; 
                        case 3 -> biayaTravel=250000;
                        case 4 -> biayaTravel=175000;
                        case 5 -> biayaTravel=125000;
                }

                //mencetak total tagihan pengguna berdasarkan rute travel yang ia pilih
                System.out.printf("Terimakasih sudah menggunakan jasa kami, total tagihan anda Rp%d",biayaTravel);
                }
            } else if (statusUser.equalsIgnoreCase("admin")){

                while (opsi!=4) {
                        // Menampilkan menu utama
                        System.out.printf("%n%-5s %s%n", "", "========== Menu ==========");
                        System.out.printf("%-5s %-3s %s%n", "", "1.", "Input Data Mobil");
                        System.out.printf("%-5s %-3s %s%n", "", "2.", "Lihat Semua Data Mobil");
                        System.out.printf("%-5s %-3s %s%n", "", "3.", "Cari Data Mobil Berdasarkan Atribut");
                        System.out.printf("%-5s %-3s %s%n", "", "4.", "Keluar");
                        System.out.printf("%-5s %s", "", "Pilih opsi: ");

                        // Membaca opsi pilihan pengguna
                        opsi = sc.nextInt();
                        sc.nextLine(); // Mengonsumsi newline agar tidak terjadi masalah saat membaca input berikutnya

                        // Menjalankan fungsi berdasarkan pilihan pengguna
                        switch (opsi) {
                            case 1:
                                inputDataMobil();
                                sudahInputMobil=true;
                                break;
                            case 2:
                                tampilkanSemuaMobil();
                                break;
                            case 3:
                                cariMobil();
                                break;
                            case 4:
                                System.out.println("Protokol admin selesai.");
                                break; // Keluar dari program
                            default:
                                System.out.println("Opsi tidak valid. Coba lagi.");
                        }
                    }
                break;
                } else {
                    System.out.println("Tolong masukkan sesuai menu");
                }
        System.out.println("Apakah anda masih ingin menggunakan applikasi?");
        System.out.print("Jawab dengan mengetik \"ya\" atau \"tidak\": ");
        sudahSelesai = sc.nextLine();
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

