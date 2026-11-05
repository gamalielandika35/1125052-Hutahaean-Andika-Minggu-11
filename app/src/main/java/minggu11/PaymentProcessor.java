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
        List<AuthorizationMethod> requiredAuthorizations = strategy.getRequiredAuthorizations();

        for (int i = 0; i < requiredAuthorizations.size(); i++) {
            AuthorizationMethod method = requiredAuthorizations.get(i);

            System.out.print("Masukkan " + method + ": ");
            String value = input.next();

            if (!strategy.validateAuthorization(method, value)) {
                System.out.println("Otorisasi gagal! Pembayaran dibatalkan.");
                return;
            }
        }
        strategy.pay(amount);
    }
}