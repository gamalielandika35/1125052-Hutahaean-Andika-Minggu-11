package minggu11;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<PaymentStrategy> paymentMethods = new ArrayList<>();

        paymentMethods.add(new Wallet("Main Wallet", 10000));
        paymentMethods.add(new DebitCard("123456789", 100000, "1234"));
        paymentMethods.add(new CreditCard("987654321", 500000, "123", "1234"));

        PaymentProcessor processor = new PaymentProcessor(input);

        while (true) {
            System.out.println("\n=== PAYMENT SYSTEM ===");
            System.out.println("1. Bikin Pembayaran");
            System.out.println("2. Tambah Pembayaran");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int menu = input.nextInt();

            if (menu == 1) {
                System.out.print("\nMasukkan jumlah yang dibayar: ");
                double amount = input.nextDouble();

                System.out.println("\nPilih metode pembayaran:");

                for (int i = 0; i < paymentMethods.size(); i++) {
                    System.out.println((i + 1) + ". " + paymentMethods.get(i).getName());
                }

                System.out.print("Pilihan: ");
                int choice = input.nextInt();

                if (choice >= 1 && choice <= paymentMethods.size()) {
                    PaymentStrategy selectedMethod = paymentMethods.get(choice - 1);
                    processor.processPayment(selectedMethod, amount);
                } else {
                    System.out.println("Pilihan tidak valid!");
                }

            } else if (menu == 2) {
                System.out.println("\n=== TAMBAH PEMBAYARAN ===");
                System.out.println("1. Cash (Wallet)");
                System.out.println("2. Debit Card");
                System.out.println("3. Credit Card");
                System.out.print("Pilih jenis pembayaran: ");
                int type = input.nextInt();

                if (type == 1) {
                    input.nextLine();

                    System.out.print("Masukkan nama wallet: ");
                    String name = input.nextLine();

                    System.out.print("Masukkan saldo wallet: ");
                    double balance = input.nextDouble();

                    paymentMethods.add(new Wallet(name, balance));
                    System.out.println("Wallet berhasil ditambahkan!");

                } else if (type == 2) {
                    input.nextLine();

                    System.out.print("Masukkan nomor kartu: ");
                    String cardNumber = input.nextLine();

                    System.out.print("Masukkan saldo debit: ");
                    double balance = input.nextDouble();

                    input.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pin = input.nextLine();

                    paymentMethods.add(new DebitCard(cardNumber, balance, pin));
                    System.out.println("Debit Card berhasil ditambahkan!");

                } else if (type == 3) {
                    input.nextLine();

                    System.out.print("Masukkan nomor kartu: ");
                    String cardNumber = input.nextLine();

                    System.out.print("Masukkan limit kredit: ");
                    double limit = input.nextDouble();

                    input.nextLine();

                    System.out.print("Masukkan CCV: ");
                    String ccv = input.nextLine();

                    System.out.print("Masukkan PIN: ");
                    String pin = input.nextLine();

                    paymentMethods.add(new CreditCard(cardNumber, limit, ccv, pin));
                    System.out.println("Credit Card berhasil ditambahkan!");

                } else {
                    System.out.println("Jenis pembayaran tidak valid!");
                }

            } else if (menu == 3) {
                System.out.println("Program selesai.");
                break;

            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        input.close();
    }
}