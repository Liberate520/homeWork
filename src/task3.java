import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class task3 {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task3.class.getName());
        FileHandler fh = new FileHandler("logtask3.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        Scanner sc = new Scanner(System.in);
        System.out.print(
                "Введите первое и второе число - ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(
                "Выберете и введите тип операции, которую вы хотите выполнить (+, -, *, /, %) -");
        char op = sc.next().charAt(0);
        solve(a, b, op);
    }

    public static int solve(int a, int b, char op) {
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '%') {
            ans = a % b;
        }
        System.out.println("Результат - " + ans);
        return ans;
    }
}
