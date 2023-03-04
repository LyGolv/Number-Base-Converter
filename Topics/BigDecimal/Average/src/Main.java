import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal()
                .add(scanner.nextBigDecimal())
                .add(scanner.nextBigDecimal())
                .divide(BigDecimal.valueOf(3), RoundingMode.DOWN)
                .toBigInteger());
    }
}