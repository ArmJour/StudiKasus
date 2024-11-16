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
        if(jumlahKaryawan == karyawan.length) {
            ubahUkuranArray();
        }

        System.out.println("Masukkan Data Karyawan : ");

        System.out.println("Masukkan Nama : ");
        String nama = sc.nextLine();

        System.out.println("Masukkan Alamat : ");
        String alamat = sc.nextLine();

        System.out.println("Masukkan Email : ");
        String email = sc.nextLine();

        long noTelp;
        while (true) {
            System.out.print("Masukkan Nomor Telpon (Mulau dengan 0) : ");
            noTelp = sc.nextLong();
            String telpStr = String.valueOf(noTelp);

            if(telpStr.startsWith("0") && (telpStr.length() >= 10 && telpStr.length() <= 13)) {
                break;
            }

            System.out.println("input tidak valid.");
        }

        char jenisKelamin;
        while (true) { 
            System.out.print("Masukkan Jenis Kelamin (M/F) : ");
            jenisKelamin = sc.next().toUpperCase().charAt(0);
            if(jenisKelamin == 'M' || jenisKelamin == 'F') {
                break;
            }
            System.out.println("Input tidak valid.");
        }

        System.out.print("Masukkan Umur : ");
        int umur = sc.nextInt(); sc.nextLine();

        System.out.print("Masukkan Kategori Karyawan (Supir travel, Supir Rentcar, Admin) : ");
        String kategoriKaryawan = sc.nextLine();
        


    }

    private String[] wrapText(String text, int maxWidth) {
        if(text.length() <= maxWidth) {
            return new String[]{text};
        }

        int start = 0;
        int end = maxWidth;
        StringBuilder line = new StringBuilder();
        int lineCount = (text.length() + maxWidth - 1) / maxWidth;
        String[] lines = new String[lineCount];

        for (int i = 0; start < text.length(); i++) {
            end = Math.min(text.length(), start + maxWidth);
            line.append(text, start, end);
            lines[i] = line.toString();
            start = end;
            line.setLength(0);
        }

        return lines;
    }

    private void ubahUkuranArray() {
        Karyawan[] karyawanBaru = new Karyawan[karyawan.length * 2];
        System.arraycopy(karyawan, 0, karyawanBaru, 0, karyawan.length);
        karyawan = karyawanBaru;
    }   
}
