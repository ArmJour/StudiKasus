    package ManajemenKaryawan;

    import java.util.Scanner;

    public class ManajerKaryawan {

        private Karyawan[] karyawan;
        private int jumlahKaryawan;
        private int[] jamLembur;
        private double[] gaji;
        private String[] kategori;
        private double[] gajiPokok;
        private double[] uangLembur;
        private double[] pajak;


        //Constructor
        public ManajerKaryawan() {
            karyawan = new Karyawan[2];
            jumlahKaryawan = 0;
            jamLembur = new int[2];
            gaji = new double[2];
            kategori = new String[]{"Supir travel", "Supir rentcar", "Admin"};
            gajiPokok = new double[]{1500000, 1750000, 2000000};
            uangLembur = new double[]{50000, 45000, 40000};
            pajak = new double[]{0.05, 0.06, 0.07};
        }

        public double hitungGajiBersih(int kategoriIndex, int jamLembur) {
            double gajiKotor = gajiPokok[kategoriIndex] + (jamLembur * uangLembur[kategoriIndex]);
            double gajiBersih = gajiKotor - (gajiKotor * pajak[kategoriIndex]);
            return gajiBersih;
        }

        public void inputUntukGaji(Scanner sc) {
            if (jumlahKaryawan == 0) {
                System.out.println("\nTidak ada data karyawan yang tersimpan.");
                return;
            }
    
            tampilKaryawan();
            System.out.println("Pilih nomor karyawan untuk menghitung gajinya:");
            int noKaryawan = sc.nextInt() - 1;
    
            if (noKaryawan < 0 || noKaryawan >= jumlahKaryawan) {
                System.out.println("Nomor tidak ada dalam daftar.");
                return;
            }
    
            Karyawan karyawanTerpilih = karyawan[noKaryawan];
            System.out.printf("Karyawan yang dipilih: %s (%s)%n", karyawanTerpilih.getNama(), karyawanTerpilih.getKategoriKaryawan());
    
            System.out.print("Masukkan jam lembur: ");
            int jamLemburInput = sc.nextInt();
    
            int kategoriIndex = -1;
            for (int i = 0; i < kategori.length; i++) {
                if (kategori[i].equalsIgnoreCase(karyawanTerpilih.getKategoriKaryawan())) {
                    kategoriIndex = i;
                    break;
                }
            }
    
            if (kategoriIndex != -1) {
                jamLembur[noKaryawan] = jamLemburInput;
                gaji[noKaryawan] = hitungGajiBersih(kategoriIndex, jamLemburInput);
                System.out.println("Gaji berhasil dihitung dan disimpan!");
            } else {
                System.out.println("Kategori karyawan tidak valid.");
            }
        }


        public void inputKaryawan(Scanner sc) {
            sc.nextLine();
            while (true) {
                if(jumlahKaryawan == karyawan.length) {
                    ubahUkuranArray();
                }
        
                System.out.println("\nMasukkan Data Karyawan : ");
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
        

                
                String kategoriKaryawan = "";
                int NoKategoriKaryawan = 0;
                while(NoKategoriKaryawan > 3 || NoKategoriKaryawan <= 0){

                    System.out.print("Masukkan Kategori Karyawan \n1. Supir travel\n2. Supir Rentcar\n3. Admin\nKategori : ");
                    NoKategoriKaryawan = sc.nextInt();

                    switch (NoKategoriKaryawan) {
                        case 1 -> kategoriKaryawan = "Supir Travel";
                        case 2 -> kategoriKaryawan = "Supir Rentcar";
                        case 3 -> kategoriKaryawan = "Admin";
                        default -> System.out.println("Input tidak valid");

                    }
                }
                
                sc.nextLine();

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

        public void tampilGajiKaryawan() {
            if (jumlahKaryawan == 0) {
                System.out.println("\nTidak ada data karyawan yang tersimpan.");
                return;
            }
    
            System.out.println("\nDATA KARYAWAN DENGAN GAJI:");
            System.out.printf("+-----------------+------+------------+---------------+%n");
            System.out.printf("| %-15s | %-4s | %-10s | %-13s |%n", "Nama", "Umur", "Jam Lembur", "Gaji");
            System.out.printf("+-----------------+------+------------+---------------+%n");
    
            for (int i = 0; i < jumlahKaryawan; i++) {
                if (jamLembur[i] > 0) {
                    System.out.printf("| %-15s | %-4d | %-10d | Rp%-11.2f |%n",
                            karyawan[i].getNama(), karyawan[i].getUmur(), jamLembur[i], gaji[i]);
                }
            }
    
            System.out.printf("+-----------------+------+------------+---------------+%n");
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
            int[] jamLemburBaru = new int[karyawan.length * 2];
            double[] gajiBaru = new double[karyawan.length * 2];
    
            System.arraycopy(karyawan, 0, karyawanBaru, 0, karyawan.length);
            System.arraycopy(jamLembur, 0, jamLemburBaru, 0, jamLembur.length);
            System.arraycopy(gaji, 0, gajiBaru, 0, gaji.length);
    
            karyawan = karyawanBaru;
            jamLembur = jamLemburBaru;
            gaji = gajiBaru;
        }   
    }
