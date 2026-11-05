package minggu11;

public interface AuthorizationStrategy {
    String getName();
    boolean validate(String value);
}