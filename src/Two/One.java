import java.math.BigInteger;

public class One {
    public static void main(String[] args) {
        Rational a = new Rational(-2, -4);

        System.out.println("a:");
        singleRationalReport(a);

        Rational b = new Rational(64, 128);
        System.out.println("b:");
        singleRationalReport(b);

        pairRationalReport(a, b);

        b = new Rational(32, 128);
        System.out.println("b:");
        singleRationalReport(b);
 
        pairRationalReport(a, b);

        a = new Rational(30, 231);
        System.out.println("a:");
        singleRationalReport(a);

        b = new Rational(130, 52);
        System.out.println("b:");
        singleRationalReport(b);

        pairRationalReport(a, b);
    }

    public static void singleRationalReport(Rational a) {
        System.out.println("as is: " + a.toString());
        System.out.println("canonical: " + a.toString(true));
    }

    public static void pairRationalReport(Rational a, Rational b) {
        Rational result;
        System.out.println("a == b: " + (a.equals(b) ? "yes" : "no"));
        System.out.println("a <=> b: " + a.compareTo(b));
        System.out.println("b <=> a: " + b.compareTo(a));

        result = a.add(b);
        System.out.println("a + b = " + result.toString());
        System.out.println("a + b = " + result.toString(true) + " (canonical)");

        result = a.sub(b);
        System.out.println("a - b = " + result.toString());
        System.out.println("a - b = " + result.toString(true) + " (canonical)");

        result = a.mul(b);
        System.out.println("a * b = " + result.toString());
        System.out.println("a * b = " + result.toString(true) + " (canonical)");

        result = a.div(b);
        System.out.println("a / b = " + result.toString());
        System.out.println("a / b = " + result.toString(true) + " (canonical)");
    }
}
