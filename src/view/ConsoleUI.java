package view;

import model.person.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
    }
    @Override
    public void start() {

    }

    @Override
    public void printOutput(String text) {
        System.out.println(text);
    }

    public void addPerson () {
        String name = scanner.nextLine();
        String surname = scanner.nextLine();
        String patronymic = scanner.nextLine();
        Gender gender = (scanner.nextLine().equals("1")) ? Gender.MALE : Gender.FEMALE;
        LocalDate dateBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    }
}
