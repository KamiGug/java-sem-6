import java.math.BigInteger;

public class Four {
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
        
        System.out.print("Binary: ");
        System.out.println(toBinary(n));
        System.out.print("Octonary: ");
        System.out.println(toOctonary(n));
        System.out.print("Hexadecimal: ");
        System.out.println(toHexadecimal(n));
    }

    public static String getDigit(int value) {
        if (value < 10) {
            return String.valueOf(value);
        } else {
            return Character.toString((int) 'a' + value - 10);
        }
    }


    public static String toBinary(int value) {
        return getRepresantationByBase(value, 2);
    }

    public static String toOctonary(int value) {
        return getRepresantationByBase(value, 8);
    }

    public static String toHexadecimal(int value) {
        return getRepresantationByBase(value, 16);
    }

    public static String getRepresantationByBase(int value, int base) {
        String result = "";
        while (value != 0) {
            result = getDigit(value % base).concat(result);
            value = value / base;
        }
        return result;
    }

}
