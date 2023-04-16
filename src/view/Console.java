package view;

import model.human.Gender;
import presenter.Presenter;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter; //<-- Куда отправлять сигнал
    private Scanner scanner;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }

    }

    public void addHuman() {
        System.out.println("Введите имя человека: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию человека: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите пол человека (м / ж): ");
        String ans = scanner.nextLine();
        Gender gender = null;
        if (ans == "м") { gender = Gender.Male; }
        else { gender = Gender.Female; }

        presenter.addHuman(firstName, lastName, gender);
    }

    public void getHumanList() {
        presenter.getHumanList();
    }
}
