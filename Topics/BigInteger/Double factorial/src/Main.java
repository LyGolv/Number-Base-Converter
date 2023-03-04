import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        return doubleFactorial(BigInteger.valueOf(n));
    }

    private static BigInteger doubleFactorial(BigInteger n) {
        return n.compareTo(BigInteger.TWO) < 0 ?
                BigInteger.ONE
                : n.multiply(doubleFactorial(n.subtract(BigInteger.TWO)));
    }
}