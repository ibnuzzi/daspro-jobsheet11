import java.util.Scanner;
public class PenjualanCafe {
    public static void tampilkanPenjualan(String[] menu, int[][] penjualan) {
        System.out.println("\nData Penjualan:");
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i] + ": ");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print(penjualan[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void menuPenjualanTertinggi(String[] menu, int[][] penjualan) {
        int maxPenjualan = 0;
        String menuTerlaris = "";
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > maxPenjualan) {
                maxPenjualan = totalPenjualan;
                menuTerlaris = menu[i];
            }
        }
        System.out.println("\nMenu dengan penjualan tertinggi: " + menuTerlaris + " (Total: " + maxPenjualan + ")");
    }

    public static void rataRataPenjualan(String[] menu, int[][] penjualan) {
        System.out.println("\nRata-rata penjualan untuk setiap menu:");
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            double rataRata = (double) totalPenjualan / penjualan[i].length;
            System.out.println(menu[i] + ": " + rataRata);
        }
    }

    public static void inputDataPenjualan(String[] menu, int[][] penjualan) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMasukkan data penjualan baru:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("Masukkan data penjualan untuk " + menu[i] + " (7 hari):");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print("Hari ke-" + (j + 1) + ": ");
                penjualan[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nData penjualan berhasil diupdate.");
    }

    public static void main(String[] args) {
        String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};
        int[][] penjualan = {
            {20, 20, 25, 20, 10, 60, 10},
            {30, 80, 40, 10, 15, 20, 25},
            {5, 9, 20, 25, 10, 50, 45},  
            {50, 8, 17, 18, 10, 30, 6},  
            {15, 10, 16, 15, 10, 10, 55}
        };

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n--- Menu Program Penjualan Cafe ---");
            System.out.println("1. Tampilkan seluruh data penjualan");
            System.out.println("2. Input atau ubah data penjualan");
            System.out.println("3. Tampilkan menu dengan penjualan tertinggi");
            System.out.println("4. Tampilkan rata-rata penjualan setiap menu");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanPenjualan(menu, penjualan);
                    break;
                case 2:
                    inputDataPenjualan(menu, penjualan);
                    break;
                case 3:
                    menuPenjualanTertinggi(menu, penjualan);
                    break;
                case 4:
                    rataRataPenjualan(menu, penjualan);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 5);
    }
}
