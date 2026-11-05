package minggu11;

public class CCVAuthorization implements AuthorizationStrategy {
    String ccv;

    public CCVAuthorization(String ccv) {
        this.ccv = ccv;
    }


    public String getName() {
        return "CCV";
    }

   
    public boolean validate(String value) {
        return ccv.equals(value);
    }
}