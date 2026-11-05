package minggu11;

public class CreditCard implements PaymentMethod {
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


    public void pay(double amount) {
        if (validate(amount)) {
            currentDebt += amount;
            System.out.println("Pembayaran credit berhasil, sisa limit: " + (limit - currentDebt));
        } else {
            System.out.println("Limit credit tidak mencukupi!");
        }
    }
}