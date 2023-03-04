import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new BigDecimal(scanner.nextLine()).setScale(scanner.nextInt(), RoundingMode.HALF_DOWN));
    }   
}