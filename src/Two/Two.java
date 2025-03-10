public class Two {
    public static void main(String[] args) {
        Quadratic a = new Quadratic(1, 0, 0);
        System.out.println("a=1, b=0, c=0");
        quadraticReport(a);

        a.setC(-4);
        System.out.println("a=1, b=0, c=-4");
        quadraticReport(a);

        a.setA(0);
        System.out.println("a=0, b=0, c=-4");
        quadraticReport(a);

        a.setC(0);
        System.out.println("a=0, b=0, c=0");
        quadraticReport(a);

        a.setB(1);
        System.out.println("a=0, b=1, c=0");
        quadraticReport(a);

        a.setA(-3);
        System.out.println("a=-3, b=1, c=0");
        quadraticReport(a);

        a = new Quadratic(1, 0, 1);
        System.out.println("a=1, b=0, c=1");
        quadraticReport(a);


    }

    private static void quadraticReport(Quadratic quad) {
        System.out.println("f(0) = " + quad.getY(0));
        System.out.println("f(1) = " + quad.getY(1));
        System.out.println("f(2) = " + quad.getY(2));
        System.out.println("f(4) = " + quad.getY(4));
        System.out.println("|{x: f(x) = 0}| = " + quad.getCountOfXIntersections());
    }
}
