package minggu11;

import java.util.List;
import java.util.Scanner;

public class PaymentProcessor {
    Scanner input;

    public PaymentProcessor(Scanner input) {
        this.input = input;
    }

    public void processPayment(PaymentStrategy strategy, double amount) {
        if (!strategy.validate(amount)) {
            System.out.println("Pembayaran gagal! Saldo atau limit tidak mencukupi.");
            return;
        }

        List<AuthorizationStrategy> requiredAuthorizations =
                strategy.getRequiredAuthorizations();

        for (int i = 0; i < requiredAuthorizations.size(); i++) {
            AuthorizationStrategy authorization = requiredAuthorizations.get(i);

            System.out.print("Masukkan " + authorization.getName() + ": ");
            String value = input.next();

            if (!authorization.validate(value)) {
                System.out.println("Otorisasi gagal! Pembayaran dibatalkan.");
                return;
            }
        }

        strategy.pay(amount);
    }
}