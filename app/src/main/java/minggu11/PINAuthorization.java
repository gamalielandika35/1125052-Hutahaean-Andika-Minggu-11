package minggu11;

public class PINAuthorization implements AuthorizationStrategy {
    String pin;

    public PINAuthorization(String pin) {
        this.pin = pin;
    }
   
    public String getName() {
        return "PIN";
    }
    public boolean validate(String value) {
        return pin.equals(value);
    }
}