public class FunkcjaLiniowa implements Wielomian {
    private double a;
    private double b;

    public FunkcjaLiniowa(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        if (a == 0) {
            if (b == 0) {
                System.out.println("x ∈ R");
            } else {
                System.out.println("brak");
            }
        } else {
            System.out.println(-this.b / this.a);
        }
    }
}
