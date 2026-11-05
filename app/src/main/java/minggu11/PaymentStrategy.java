package minggu11;

import java.util.List;

public interface PaymentStrategy extends PaymentMethod {
    List<AuthorizationStrategy> getRequiredAuthorizations();

    boolean canPay(double amount);
}