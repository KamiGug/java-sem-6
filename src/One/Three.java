import java.math.BigInteger;

public class Three {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Missing argument!");
            System.exit(100);
        }
        int n = 0;
        try {
            n = (new BigInteger(args[0])).intValue();
        } catch (Exception e) {
            System.out.println("Bad argument!");
            System.exit(200);
        }
        // int sum = 0;
        // for (int i = 1; i <= n; i += 2) {
        //     sum += i;
        // }
        int sum = ((1 + (n % 2 == 0 ? n - 1 : n) ) / 2) * (n/2 + (n%2));  
        System.out.println(sum);
    }
 
}
