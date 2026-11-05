package minggu11;

import java.util.List;

public interface PaymentStrategy extends PaymentMethod {
    List<AuthorizationMethod> getRequiredAuthorizations();

    boolean validateAuthorization(AuthorizationMethod method, String value);

    boolean canPay(double amount);
}