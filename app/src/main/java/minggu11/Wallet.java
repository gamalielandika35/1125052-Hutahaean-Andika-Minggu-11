package minggu11;

public class Wallet {
    String name;
    double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    public boolean validate(double amount) {
        return cashValue >= amount;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            cashValue -= amount;
            System.out.println("Pembayaran cash berhasil, sisa wallet: " + cashValue);
        } else {
            System.out.println("Saldo wallet tidak mencukupi!");
        }
    }
}