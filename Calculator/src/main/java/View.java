import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public View(Presenter sum, Presenter sub, Presenter mult, Presenter div) {
    }

    public View() {

    }

    public double getValue(String title) {
        System.out.printf("%s", title);
        return in.nextDouble();
    }

    public void print(double data, String title) {
        System.out.printf("%s %.3f\n", title, data);
    }
    public void ViewStart (Presenter sum, Presenter sub, Presenter mult, Presenter div) {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите команду: '+', '-', '*', '/'\n или нажмите 'E' для выхода");
                String key = in.next();
                switch (key) {
                    case "+":
                        sum.startAction();
                        break;
                    case "-":
                        sub.startAction();
                        break;
                    case "*":
                        mult.startAction();
                        break;
                    case "/":
                        div.startAction();
                        break;
                    case "E", "e":
                        System.exit(0);


                    default:
                        System.out.println("Комманда не распознана. Повторите ввод!\n");
                        break;
                }
            }
        }
    }
}

