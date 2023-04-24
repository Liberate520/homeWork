package ui;

import presenter.Presenter;

import java.io.IOException;
import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.Scanner;

import model.familyTreeApi.Human;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;

    public ConsoleUI() {
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
        while (true){
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }

    public String scanFirstName() {
        System.out.println("введите имя: ");
        String firstName = scanner.nextLine();
        return firstName;
    }

    public String scanSecondName() {
        System.out.println("введите фамилию: ");
        String secondName = scanner.nextLine();
        return secondName;
    }

    public int scanInt() {
        int i = scanner.nextInt();
        return i;
    }

    public void add() {

        String firstName = scanFirstName();
        String secondName = scanSecondName();

        System.out.println("введите год рождения: ");
        int year = scanInt();

        System.out.println("введите номер месяца: ");
        int mm = scanInt();

        System.out.println("Введите день: ");
        int day = scanInt();


        LocalDate birthDate = LocalDate.of(year, mm, day);

        System.out.println("введите пол (Male, Female): ");
        String sex = scanner.nextLine();

        presenter.add(firstName, secondName, birthDate, sex);
    }

    public void deleteByName() {
        String firstName = scanFirstName();
        String lastName = scanSecondName();
        presenter.deleteByName(firstName, lastName);
    }

    public void getHumanByName() {
        printTree();
        String firstName = scanFirstName();
        for (Human human : presenter.getHumansList()) {
            if (human.getFirstName().equals(firstName)) {
              System.out.println(human);
            }
        }
    }

    public void printTree() {
        System.out.println(presenter.printTree());
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveFile() throws IOException {
        presenter.saveFile();
    }

    public void readFile() {
        presenter.readFile();
    }
}
