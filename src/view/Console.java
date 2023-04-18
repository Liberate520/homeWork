package view;

import model.human.Gender;
import presenter.Presenter;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter; //<-- Куда отправлять сигнал
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.execute(choice);
            } else {
                fail();
            }
        }
    }

    private boolean check(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() &&
                Integer.parseInt(text) > 0;
    }
    public void finish(){
        System.out.println("Завершение ");
        work = false;
    }
    public void fail() { System.out.println("Неверные входные данные "); }
    public void getTreeInfo(){ presenter.getTreeInfo(); }
    @Override
    public void setPresenter(Presenter presenter) { this.presenter = presenter; }

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

    public void getHumanList() { presenter.getHumanList(); }
    public void sortByFirstName() { presenter.sortByFirstName(); }
    public void sortByLastName() { presenter.sortByLastName(); }
    public void sortById() { presenter.sortById(); }
    public void sortByGender() { presenter.sortByGender(); }
    public void searchHuman() { presenter.searchHuman(); }

    public void dataSave() { presenter.dataSave(); }
}
