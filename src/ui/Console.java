package ui;

import java.util.Scanner;
import presenter.Presenter;

public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            }
            else {
                System.out.println("Некорректный ввод");
            }
        }
    }

    private boolean checkInput(String text) {
        if (Integer.parseInt(text) >= 0 && Integer.parseInt(text) < menu.getCommands().size() + 1 ) {    //        return text.matches("[0-9]+");
            return true;
        }
        else {
            return false;
        }
    }


    private void hello() {
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void finish() {
        work = false;
    }

    public void addHuman() {
        System.out.println("Введите текст");
        presenter.addHuman(scanner.nextLine());
    }
}
