package minggu11;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements PaymentStrategy {
    String name;
    double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    public String getName() {
        return "Cash - " + name;
    }

    public boolean validate(double amount) {
        return cashValue >= amount;
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100 && amount <= 1000000;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            cashValue -= amount;
            System.out.println("Pembayaran cash berhasil, sisa wallet: " + cashValue);
        } else {
            System.out.println("Saldo wallet tidak mencukupi!");
        }
    }

public List<AuthorizationStrategy> getRequiredAuthorizations() {
    return new ArrayList<>();
}
}