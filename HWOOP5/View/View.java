package View;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public Double getValue(String text){
        while (true) {
            try {
                System.out.printf("%s ", text);
                double value = scanner.nextDouble();
                if(value == 0){
                    throw new ArithmeticException();
                }
                else{
                    return value;
                  }
            } catch (ArithmeticException e) {
                System.out.println("Second operand has to be positive or negative not zero, try again.");
            } 
        }
    }

    public void print(Double x, String operand, Double y, Double value){
        System.out.printf("%.3f %s %.3f = %.3f \n", x, operand, y, value);
        System.out.println();
    }
}
