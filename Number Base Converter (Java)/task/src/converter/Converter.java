package converter;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Converter {
    public BigDecimal convertTo10(String number, int base) {
        String[] part = number.split("\\.");
        BigDecimal result = convertPartTo10(part[0], base, part[0].length() - 1);
        if (part.length == 2) result = result.add(convertPartTo10(part[1], base, -1));
        return result;
    }

    private BigDecimal convertPartTo10(String number, int base, int exp) {
        BigDecimal result = BigDecimal.ZERO;
        for (int i = number.length() - 1; i >= 0; --i) {
            char digit = number.charAt(i);
            BigDecimal val = BigDecimal.valueOf(getOnBase10(digit))
                    .multiply(BigDecimal.valueOf(Math.pow(base, exp - i)));
            result = result.add(val);
        }
        return result;
    }

    public String convertToBase(BigDecimal number, int base, boolean isDecimal) {
        BigInteger integer = number.toBigInteger();
        String integerPart = convertIntegerPartToBase(integer, base);
        BigDecimal fractional = number.remainder(BigDecimal.ONE);
        String fractionalPart = !isDecimal ? "" : convertFractionalPartToBase(fractional, base);
        return fractionalPart.isEmpty() ? integerPart : integerPart + "." + fractionalPart;
    }

    private String convertIntegerPartToBase(BigInteger number, int base) {
        StringBuilder result = new StringBuilder();
        while (!number.equals(BigInteger.ZERO)) {
            result.append(getOnBase36(number.mod(BigInteger.valueOf(base)).intValue()));
            number = number.divide(BigInteger.valueOf(base));
        }
        return result.isEmpty() ? "0" : result.reverse().toString();
    }

    private String convertFractionalPartToBase(BigDecimal number, int base) {
        StringBuilder result = new StringBuilder();
        while (result.length() < 5) {
            number = number.remainder(BigDecimal.ONE)
                    .multiply(BigDecimal.valueOf(base));
            result.append(getOnBase36(number.toBigInteger().intValue()));
        }
        return result.toString();
    }

    private String getOnBase36(int val) {
        return val >= 10 ? Character.toString('A' + val - 10) : val + "";
    }

    private int getOnBase10(char c) {
        return Character.isDigit(c) ? c - '0' : 10 + c - 'A';
    }
}
