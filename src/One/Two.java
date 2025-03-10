import java.math.BigInteger;

public class Two {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing argument!");
            System.exit(100);
        }
        BigInteger n = BigInteger.ZERO;
        try {
            n = new BigInteger(args[0]);
        } catch (Exception e) {
            System.out.println("Bad argument!");
            System.exit(200);
        }
        System.out.println(n); 
        BigInteger output = BigInteger.ONE;
        for (
            BigInteger i = BigInteger.valueOf(2); 
            n.compareTo(i) > -1; 
            i = i.add(BigInteger.ONE)) {
            output = output.multiply(i);
        }
        System.out.print(n);
        System.out.print("! = ");
        System.out.println(output);
        System.exit(0);
    }
}
