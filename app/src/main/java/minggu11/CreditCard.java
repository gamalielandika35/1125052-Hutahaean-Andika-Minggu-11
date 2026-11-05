package minggu11;

import java.util.ArrayList;
import java.util.List;

public class CreditCard implements PaymentStrategy {
    String cardNumber;
    double limit;
    double currentDebt;
    String ccv;
    String pin;

    public CreditCard(String cardNumber, double limit, String ccv, String pin) {
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.currentDebt = 0;
        this.ccv = ccv;
        this.pin = pin;
    }

    public String getName() {
        return "Credit Card - " + cardNumber;
    }

    public boolean validate(double amount) {
        return currentDebt + amount <= limit;
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100000 && amount <= 100000000;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            currentDebt += amount;
            System.out.println("Pembayaran credit berhasil, sisa limit: " + (limit - currentDebt));
        } else {
            System.out.println("Limit credit tidak mencukupi!");
        }
    }

    @Override
    public List<AuthorizationStrategy> getRequiredAuthorizations() {
        List<AuthorizationStrategy> authorizations = new ArrayList<>();
        authorizations.add(new CCVAuthorization(ccv));
        authorizations.add(new PINAuthorization(pin));
        return authorizations;
    }
}