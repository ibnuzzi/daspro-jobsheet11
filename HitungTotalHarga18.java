import java.util.Scanner;
public class HitungTotalHarga18 {
    public static int HitungTotalHarga(int pilihanMenu, int banyakItem, String kodePromo){
        double diskon = 0;
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        if (kodePromo.equals("DISKON50")) {
            diskon = hargaTotal * 0.5; 
            hargaTotal -= diskon;
            System.out.println("Anda mendapatkan diskon 50%!");
        } else if (kodePromo.equals("DISKON30")) {
            diskon = hargaTotal * 0.3;
            hargaTotal -= diskon;
            System.out.println("Anda mendapatkan diskon 30%!");
        } else {
            System.out.println("Kode promo tidak valid.");
        }

        return hargaTotal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalHargaKeseluruhan = 0;
        
        while (true) {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (1-6) atau 0 untuk selesai: ");
            int pilihanMenu = sc.nextInt();
            if (pilihanMenu == 0) {
                break;
            }
            
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();
            sc.nextLine();

            System.out.print("Masukkan kode promo: ");
            String kodePromo = sc.nextLine();
            
            int totalHarga = HitungTotalHarga(pilihanMenu, banyakItem, kodePromo);
            totalHargaKeseluruhan += totalHarga;

            System.out.println("Total harga untuk pesanan ini: Rp " + totalHarga);
        }

        System.out.println("\nTotal harga keseluruhan pesanan Anda: Rp " + totalHargaKeseluruhan);
    }
}
