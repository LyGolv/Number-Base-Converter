package converter;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConverterProgram {

    private final Scanner scanner = new Scanner(System.in);
    private final Converter converter = new Converter();

    public void launch() {
        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String input = scanner.nextLine();
            if (input.equals("/exit")) return;
            String[] val = input.split(" ");
            while(true) {
                if (!processConversion(Integer.parseInt(val[0]), Integer.parseInt(val[1]))) break;
            }
        }
    }

    private boolean processConversion(int source, int target) {
        System.out.print("Enter number in base " + source + " to convert to base "+ target + " (To go back type /back) ");
        String input = scanner.nextLine().toUpperCase();
        if (input.equalsIgnoreCase("/back")) return false;
        boolean isDecimal = input.split("\\.").length == 2;
        BigDecimal number = converter.convertTo10(input, source);
        System.out.println("Conversion result: " + converter.convertToBase(number, target, isDecimal));
        return true;
    }
}
