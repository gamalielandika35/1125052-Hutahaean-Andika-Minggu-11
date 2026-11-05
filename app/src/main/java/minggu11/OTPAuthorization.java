package minggu11;

public class OTPAuthorization implements AuthorizationStrategy {
    String otp;

    public OTPAuthorization(String otp) {
        this.otp = otp;
    }
    public String getName() {
        return "OTP";
    }
    public boolean validate(String value) {
        return otp.equals(value);
    }
}