public class FunkcjaKwadratowa implements Wielomian {
    private double a;
    private double b;
    private double c;

    public FunkcjaKwadratowa(double a, double b, double c) {
        if (a == 0) {
            throw new ArithmeticException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        double delta = this.b * this.b - (4 * this.a * this.c);
        if (delta < 0.0000000000001 && delta > -0.0000000000001) {
            System.out.println(-this.b / 2 * this.a); // 1
            return;
        }
        if (delta < 0) {
            System.out.println("brak"); // 0
            return;
        }
        if (delta > 0) {
            System.out.println(
                    ((-this.b - Math.sqrt(delta)) / (2 * this.a))
                            + " "
                            + ((-this.b + Math.sqrt(delta)) / (2 * this.a))); // 2
            return;
        }
        throw new ArithmeticException();
    }
}
