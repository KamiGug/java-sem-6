public class Quadratic {
    private double a;
    private double b;
    private double c;

    Quadratic(double a, double b, double c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getY(double x) {
        return a * x * x + b * x + c;
    }

    public double getCountOfXIntersections() {
        if (a == 0) {
            if (b != 0) {
                return 1;
            }
            if (c != 0) {
                return 0;
            }
            return Double.POSITIVE_INFINITY;
        }
        double delta = this.b * this.b - (4 * this.a * this.c);
        if (delta < 0.0000000000001 && delta > -0.0000000000001) {
            return 1;
        }
        if (delta < 0) {
            return 0;
        }
        if (delta > 0) {
            return 2;
        }
        throw new ArithmeticException();
    }
}
