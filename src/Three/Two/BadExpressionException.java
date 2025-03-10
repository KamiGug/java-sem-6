public class BadExpressionException extends Exception {
    public BadExpressionException(String message) {
        super(message.length() > 0 ? message : "Bad Expression");
    }
}
