package minggu11;

public class DebitCard implements PaymentMethod {
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
}