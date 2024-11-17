package ManajemenMobil;

import java.util.Scanner;

public class ManajerMobil {
    private Mobil[] mobil;
    private int jumlahMobil;
    private Scanner sc;

    
    //Constructor
    public ManajerMobil(){
        mobil = new Mobil[2];
        jumlahMobil = 0;
        sc = new Scanner(System.in);
    }

    public void inputDataMobil() {
        if(jumlahMobil == mobil.length){
            ubahUkuranArray();
        }

        System.out.println("Masukkan data mobil:");
        System.out.print("Contoh: B1234XYZ,Toyota,Putih,2021\n");
        System.out.print("No Plat: ");
        String noPlat = sc.nextLine();

        System.out.print("Merk Mobil: ");
        String merkMobil = sc.nextLine();

        System.out.print("Warna Mobil: ");
        String warnaMobil = sc.nextLine();

        System.out.print("Tahun Keluaran: ");
        int tahunKeluaran = sc.nextInt();
        sc.nextLine();

        mobil[jumlahMobil++] = new Mobil(noPlat, merkMobil, warnaMobil, tahunKeluaran);
        System.out.println("Data mobil berhasil ditambahkan.");
    }

    public void cariMobil(){
        System.out.print("Masukkan nilai untuk pencarian: ");
        String nilai = sc.nextLine();

        System.out.printf("\n%-10s %-15s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun");
        System.out.println("--------------------------------------------------------");

        boolean ditemukan = false;
        for (int i = 0; i < jumlahMobil; i++) {
            Mobil car = mobil[i];
            if (cocokkanAtribut(car, nilai)) {
                System.out.printf("%-10s %-15s %-10s %-10d\n", 
                    car.getNoPlat(), car.getMerkMobil(), car.getWarnaMobil(), car.getTahunKeluaran());
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada mobil yang sesuai dengan pencarian.");
        }
    }

    public void tampilSemuaMobil(){
        if (jumlahMobil == 0) {
            System.out.println("\nTidak ada data mobil yang tersimpan.");
            return;
        }

        System.out.printf("\n%-10s %-15s %-10s %-10s\n", "No Plat", "Merk Mobil", "Warna", "Tahun");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < jumlahMobil; i++) {
            Mobil car = mobil[i];
            System.out.printf("%-10s %-15s %-10s %-10d\n", 
                car.getNoPlat(), car.getMerkMobil(), car.getWarnaMobil(), car.getTahunKeluaran());
        }
    }

    private boolean cocokkanAtribut(Mobil mobil, String nilai) {
        return mobil.getNoPlat().equalsIgnoreCase(nilai) ||
               mobil.getMerkMobil().equalsIgnoreCase(nilai) ||
               mobil.getWarnaMobil().equalsIgnoreCase(nilai) ||
               String.valueOf(mobil.getTahunKeluaran()).equals(nilai);
    }

    public void ubahUkuranArray(){
        Mobil[] mobilBaru = new Mobil[mobil.length * 2];
        System.arraycopy(mobil, 0, mobilBaru, 0, mobil.length);
        mobil = mobilBaru;
    }
}
