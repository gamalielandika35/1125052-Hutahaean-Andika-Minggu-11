package minggu11;
import java.util.ArrayList;
import java.util.List;

public class DebitCard implements PaymentStrategy {
    String cardNumber;
    double balance;
    String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getName() {
        return "Debit Card - " + cardNumber;
    }

    public boolean canPay(double amount) {
        return amount > 0 && amount <= 10000000;
    }

    public boolean validate(double amount) {
        return balance >= amount;
    }
    public void pay(double amount) {
        if (validate(amount)) {
            balance -= amount;
            System.out.println("Pembayaran debit berhasil, sisa saldo: " + balance);
        } else {
            System.out.println("Saldo debit tidak mencukupi!");
        }
    }
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> authorizations = new ArrayList<>();
        authorizations.add(AuthorizationMethod.PIN);
        return authorizations;
    }
    public boolean validateAuthorization(AuthorizationMethod method, String value) {
        if (method == AuthorizationMethod.PIN) {
            return pin.equals(value);
        }

        return false;
    }
}