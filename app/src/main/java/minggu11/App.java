package minggu11;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Wallet wallet = new Wallet("Main Wallet", 10000);
        DebitCard debitCard = new DebitCard("123456789", 100000, "1234");

        while (true) {
            System.out.print("Masukkan jumlah yang dibayar: ");
            double amount = input.nextDouble();

            System.out.println("Pilih metode pembayaran:");
            System.out.println("1. Cash");
            System.out.println("2. Debit");
            System.out.print("Pilihan: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    wallet.pay(amount);
                    break;
                case 2:
                    debitCard.pay(amount);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}