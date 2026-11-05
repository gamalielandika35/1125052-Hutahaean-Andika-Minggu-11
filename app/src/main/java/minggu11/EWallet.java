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

   
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        List<AuthorizationMethod> authorizations = new ArrayList<>();
        authorizations.add(AuthorizationMethod.PIN);
        authorizations.add(AuthorizationMethod.OTP);
        return authorizations;
    }

    
    public boolean validateAuthorization(AuthorizationMethod method, String value) {
        if (method == AuthorizationMethod.PIN) {
            return pin.equals(value);
        } else if (method == AuthorizationMethod.OTP) {
            return value.equals("123456");
        }

        return false;
    }

  
    public boolean canPay(double amount) {
        return amount > 0 && amount <= balance;
    }
}