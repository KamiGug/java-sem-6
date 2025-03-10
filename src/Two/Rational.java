import java.lang.Comparable;

public class Rational {
    private int numerator;
    private int denominator;
    private int canonicalNumerator;
    private int canonicalDenominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        this.numerator = numerator;
        this.denominator = denominator;

        if (numerator == 0) {
            this.canonicalDenominator = 1;
            this.canonicalNumerator = 0;
        } else {
            int gcd = greatestCommonDenominator(numerator, denominator);
            if (denominator < 0) {
                this.canonicalDenominator =  -denominator / gcd;
                this.canonicalNumerator = -numerator / gcd;
            } else {
                this.canonicalDenominator = denominator / gcd;
                this.canonicalNumerator = numerator / gcd;
            }
        }
    }

    public Rational add(Rational arg) {
        return new Rational(
            this.numerator * arg.denominator + arg.numerator * this.denominator,
            this.denominator * arg.denominator
        );
    }

    public Rational sub(Rational arg) {
        return new Rational(
            this.numerator * arg.denominator - arg.numerator * this.denominator,
            this.denominator * arg.denominator
        );
    }

    public Rational mul(Rational arg) {
        return new Rational(
            this.numerator * arg.numerator,
            this.denominator * arg.denominator
        );
    }

    public Rational div(Rational arg) {
        return new Rational(
            this.numerator * arg.denominator,
            this.denominator * arg.numerator
        );
    }

    public boolean equals(Rational arg) {
        return this.canonicalNumerator == arg.canonicalNumerator
            && this.canonicalDenominator == arg.canonicalDenominator;
    }

    public int compareTo(Rational arg) {
        if (this.equals(arg)) {
            return 0;
        }
        if (
            this.canonicalNumerator * arg.canonicalDenominator 
                > arg.canonicalNumerator * this.canonicalDenominator
        ) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public String toString(boolean canonical) {
        if (canonical) {
            return this.canonicalNumerator + "/" + this.canonicalDenominator;
        } 
        return this.numerator + "/" + this.denominator;
    }

    private static int greatestCommonDenominator(int a, int b) {
        if (a < 0) {
            a = -1 * a;
        }
        if (b < 0) {
            b = -1 * b;
        }
        while (a != b) {
            if (b > a) {
                //swap a and b;
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            a -= b;
        }
        return a;
    }
}
