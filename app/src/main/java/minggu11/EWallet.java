package minggu11;

import java.util.ArrayList;
import java.util.List;

public class EWallet implements PaymentStrategy {
    String phoneNumber;
    double balance;
    String pin;

    public EWallet(String phoneNumber, double balance, String pin) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getName() {
        return "E-Wallet (" + phoneNumber + ")";
    }

    public boolean validate(double amount) {
        return balance >= amount;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            balance -= amount;
            System.out.println("Pembayaran E-Wallet berhasil, sisa saldo: " + balance);
        } else {
            System.out.println("Saldo E-Wallet tidak mencukupi!");
        }
    }
    public List<AuthorizationStrategy> getRequiredAuthorizations() {
        List<AuthorizationStrategy> authorizations = new ArrayList<>();
        authorizations.add(new PINAuthorization(pin));
        authorizations.add(new OTPAuthorization("123456"));
        return authorizations;
    }

    public boolean canPay(double amount) {
        return amount > 0 && amount <= balance;
    }
}