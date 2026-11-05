package minggu11;

public interface PaymentMethod {
    String getName();
    boolean validate(double amount);
    void pay(double amount);
}