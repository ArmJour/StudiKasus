package ManajemenKaryawan;

import java.util.Scanner;

public class ManajerKaryawan {

    private Karyawan[] karyawan;
    private int jumlahKaryawan;

    //Constructor
    public ManajerKaryawan() {
        karyawan = new Karyawan[2];
        jumlahKaryawan = 0;
    }

    public void inputKaryawan(Scanner sc) {
        while (true) {
            if(jumlahKaryawan == karyawan.length) {
                ubahUkuranArray();
            }
    
            System.out.println("\nMasukkan Data Karyawan : ");
            sc.nextLine();
            System.out.print("Masukkan Nama : "); String nama = sc.nextLine();   
    
            System.out.print("Masukkan Alamat : ");
            String alamat = sc.nextLine();
    
            System.out.print("Masukkan Email : ");
            String email = sc.nextLine();
    
            String noTelp;
                while (true) {
                    System.out.print("Masukkan Nomor Telpon (Mulai dengan 0): ");
                    noTelp = sc.nextLine();
    
                    if (noTelp.matches("0\\d{9,12}")) {
                        break;
                    }
                    System.out.println("Nomor telepon tidak valid. Nomor harus mulai dengan '0' dan memiliki 10-13 digit.");
                }
    
            char jenisKelamin;
            while (true) { 
                System.out.print("Masukkan Jenis Kelamin (M/F) : ");
                jenisKelamin = sc.next().toUpperCase().charAt(0);
                sc.nextLine();
                if(jenisKelamin == 'M' || jenisKelamin == 'F') {
                    break;
                }
                System.out.println("Input tidak valid.");
            }
    
            System.out.print("Masukkan Umur : ");
            int umur = sc.nextInt(); sc.nextLine();
    
            System.out.print("Masukkan Kategori Karyawan (Supir travel, Supir Rentcar, Admin) : ");
            String kategoriKaryawan = sc.nextLine();
            
            karyawan[jumlahKaryawan++] = new Karyawan(nama, alamat, email, noTelp, jenisKelamin, umur, kategoriKaryawan);
            System.out.println("Data karyawan berhasil ditambahkan!");
    
            System.out.print("\nApakah Anda ingin menambahkan karyawan lain? (Y/N): ");
                String response = sc.nextLine().toUpperCase();
                if (!response.equals("Y")) {
                    break;
                }
        }
    }

    public void tampilKaryawan() {
        if (jumlahKaryawan == 0) {
            System.out.println("\nTidak ada data karyawan yang tersimpan.");
        } else {
            System.out.println("\nDATA KARYAWAN:");
            System.out.printf("+-----------------+----------------------+--------------------------+-----------------+----------------+------+-----------------+%n");
            System.out.printf("| %-15s | %-20s | %-24s | %-15s | %-14s | %-4s | %-15s |%n", "Nama", "Alamat", "Email", "No Telp", "Jenis Kelamin", "Umur", "Kategori");
            System.out.printf("+-----------------+----------------------+--------------------------+-----------------+----------------+------+-----------------+%n");

            for (int i = 0; i < jumlahKaryawan; i++) {
                printMultiLineRow(karyawan[i]);
            }

            System.out.printf("+-----------------+----------------------+--------------------------+-----------------+----------------+------+-----------------+%n");
        }
    }

    private void printMultiLineRow(Karyawan karyawan) {
        String[] barisNama = wrapText(karyawan.getNama(), 15);
        String[] barisAlamat = wrapText(karyawan.getAlamat(), 20);
        String[] barisEmail = wrapText(karyawan.getEmail(), 24);

        int maxLines = Math.max(barisNama.length, Math.max(barisAlamat.length, barisEmail.length));

        for (int i = 0; i < maxLines; i++) {
            System.out.printf("| %-15s | %-20s | %-24s | %-15s | %-14s | %-4s | %-15s |%n", 
                i < barisNama.length ? barisNama[i] : "", 
                i < barisAlamat.length ? barisAlamat[i] : "",
                i < barisEmail.length ? barisEmail[i] : "",
                i == 0 ? karyawan.getNoTelp() : "",
                i == 0 ? (karyawan.getJenisKelamin() == 'M' ? "Male" : "Female") : "",
                i == 0 ? karyawan.getUmur() : "",
                i == 0 ? karyawan.getKategoriKaryawan() : ""
            );
        }
    }

    private String[] wrapText(String text, int maxWidth) {
        int totalLines = (text.length() + maxWidth - 1 ) / maxWidth;
        String[] lines = new String[totalLines];

        for (int i = 0; i < totalLines; i++) {
            int start = i * maxWidth;
            int end = Math.min(start + maxWidth, text.length());
            lines[i] = text.substring(start, end);
        }

        return lines;
    }



    private void ubahUkuranArray() {
        Karyawan[] karyawanBaru = new Karyawan[karyawan.length * 2];
        System.arraycopy(karyawan, 0, karyawanBaru, 0, karyawan.length);
        karyawan = karyawanBaru;
    }   
}
