public class Two {
    public static void main(String[] args) {
        String input = "(3*((1+2)-1))";
        if (args.length > 0) {
            input = args[0];
        }
        try {
            Wyrazenie wyr = new Wyrazenie(input);
            System.out.println(wyr.oblicz());
        } catch (ArithmeticException e) {
            System.err.println("Division by zero");
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Bad Format");
        } catch (Exception e) {
            System.err.println("Unknown error!");
            throw e;
        }
    }
}
