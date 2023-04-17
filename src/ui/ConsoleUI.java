package ui;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

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

    public void add() {

        String firstName = scanFirstName();
        String secondName = scanSecondName();

        System.out.println("введите дату рождения: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.println("введите по (Male, Female): ");
        String sex = scanner.nextLine();

        presenter.add(firstName, secondName, birthDate, sex);
    }

    public void deleteByName() {
        String firstName = scanFirstName();
        String lastName = scanSecondName();
        presenter.deleteByName(firstName, lastName);
    }

    public void getHumanByName() {
        String firstName = scanFirstName();
        presenter.getHumanByName(firstName);
    }

    public void printTree() {
        presenter.printTree();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    
}
