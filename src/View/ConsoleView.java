package View;

import Presenter.Presenter;
import java.util.Scanner;

public class ConsoleView<E extends Comparable<E>> implements View {

    private final Presenter<E> presenter;

    public ConsoleView() {
        this.presenter = new Presenter<E>(this);
    }

    @Override
    public void start() {
        while (true) {
            switch (showMenu("1 - Save, 2 - Open\n", 1, 2)) {
                case 1:
                    String fileName = getInput("File name: ");
                    presenter.saveToFile(fileName);
                    break;
                case 2:
                    fileName = getInput("File name: ");
                    presenter.readFromFile(fileName);
                    break;
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private int showMenu(String menu, int min, int max) {
        int res = -1;
        do {
            System.out.println(menu);
            try {
                res = Integer.parseInt(getInput("Select: "));
            } catch (Exception e) {}
        } while (!(res >= min && res <= max));
        return res;
    }
}
