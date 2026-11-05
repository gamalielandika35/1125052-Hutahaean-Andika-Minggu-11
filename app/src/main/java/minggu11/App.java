package minggu11;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Wallet wallet = new Wallet("Main Wallet", 10000);

        while (true) {
            System.out.print("Masukkan jumlah yang dibayar: ");
            double amount = input.nextDouble();

            wallet.pay(amount);
        }
    }
}