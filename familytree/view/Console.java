package familytree.view;

import java.time.LocalDate;
import java.util.Scanner;

import familytree.model.human.Gender;
import familytree.presenter.Presenter;


public class Console implements View {

    private Scanner iScanner;
    private Presenter presenter;

    private boolean flag;
    ComandList comandList;

    public Console() {
        iScanner = new Scanner(System.in, "CP866");
        presenter = new Presenter(this);
        flag = true;
        comandList = new ComandList(this);

    }

    @Override
    public void showInfo(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Привет");
        while (flag) {
            System.out.println(comandList.showComands());
            String choise = iScanner.nextLine();
            comandList.execute(Integer.parseInt(choise));
        }

    }

    public void exit() {
        System.out.println("До свидания!");
        flag = false;

    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortBySurname() {
        presenter.sortBySurname();
    }



    public void printInfo() {
        presenter.giveInfo();
    }

    public void addHuman() {
        System.out.println("Имя: ");
        String name = iScanner.nextLine();
        System.out.println("Фамилия: ");
        String surname = iScanner.nextLine();

        System.out.println("День рождения (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(iScanner.nextLine());

        System.out.println("Пол (Мужской - M, Женский - F): ");
        Gender gender = Gender.valueOf(iScanner.nextLine());

        presenter.addHuman(name, surname, gender, dateOfBirth);

    }

}