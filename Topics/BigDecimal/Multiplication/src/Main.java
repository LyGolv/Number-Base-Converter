import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLine()).multiply(new BigDecimal(scanner.nextLine())));
    }
}