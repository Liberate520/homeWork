import java.util.Scanner;

public class Operation {
    Presenter sum;
    Presenter sub;
    Presenter mult;
    Presenter div;

    public Operation(Presenter sum, Presenter sub, Presenter mult, Presenter div) {
        this.sum = sum;
        this.sub = sub;
        this.mult = mult;
        this.div = div;
    }
}

//    public void start(Presenter sum, Presenter sub, Presenter mult, Presenter div) {
//        try (Scanner in = new Scanner(System.in)) {
//            while (true) {
//                System.out.println("Введите команду: '+', '-', '*', '/'\n или нажмите 'E' для выхода");
//                String key = in.next();
//                switch (key) {
//                    case "+":
//                        sum.startAction();
//                        break;
//                    case "-":
//                        sub.startAction();
//                        break;
//                    case "*":
//                        mult.startAction();
//                        break;
//                    case "/":
//                        div.startAction();
//                        break;
//                    case "E", "e":
//                        System.exit(0);
//
//
//                    default:
//                        System.out.println("Комманда не распознана. Повторите ввод!\n");
//                        break;
//                }
//            }
//        }
//    }
//}