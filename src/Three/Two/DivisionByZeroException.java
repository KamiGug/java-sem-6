public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String message) {
        super(message.length() > 0 ? message : "Division by zero");
    }
}
