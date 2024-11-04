import java.util.Scanner;
public class Modul2_3 {
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.println("Apakah anda ingin menggunakan jasa travel atau sewa?");
        System.out.println("jawab dengan mengetikkan \"travel\" atau \"sewa\"");
        String jenisJasa = sc.nextLine();
        if (jenisJasa.equalsIgnoreCase("sewa")){//seleksi apakah konsumen memesan jasa travel atau sewa mobil
            System.out.print("Masukkan lama jam: ");
            int jamSewa = sc.nextInt();
            sc.nextLine();
                if (jamSewa<5 && jamSewa>0){ //seleksi kondisi berdasarkan lama penyewaan mobil
                System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 400000, 100000, 500000);
            } else {
                System.out.printf("Tarif awal: Rp%d,00\nBiaya tambahan: Rp%d,00\nTotal tagihan : Rp%d,00", 450000, 150000, 600000);
            }
        } else if (jenisJasa.equalsIgnoreCase("travel")){
            int biayaTravel=0;
            System.out.println("Silahkan pilih rute travel: ");
            System.out.printf("================= Menu =================\n");
            System.out.printf("    %-15s %-12s %-12s\n","asal","tujuan","biaya");
            System.out.printf("1. %-15s %-10s Rp%-10d\n","Surabaya","Malang",100000);
            System.out.printf("2. %-15s %-10s Rp%-10d\n","Madura","Malang",200000);
            System.out.printf("3. %-15s %-10s Rp%-10d\n","Banyuwangi","Malang",250000);
            System.out.printf("4. %-15s %-10s Rp%-10d\n","Situbondo","Malang",175000);
            System.out.printf("5. %-15s %-10s Rp%-10d\n","Tulungagung","Malang",125000);
            System.out.printf("========================================\n");
            System.out.println("Masukkan nomor rute yang anda pilih");
            int rute = sc.nextInt();
            switch (rute){
                case 1 -> biayaTravel=100000;
                case 2 -> biayaTravel=200000; 
                case 3 -> biayaTravel=250000;
                case 4 -> biayaTravel=175000;
                case 5 -> biayaTravel=125000;
            }  
            System.out.printf("Terimakasih sudah menggunakan jasa kami, total tagihan anda Rp%d",biayaTravel);
        }        
    }
}
