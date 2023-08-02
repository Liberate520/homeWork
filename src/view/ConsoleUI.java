package view;

import model.person.Gender;
import model.person.Person;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private TextUI text;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.text = new TextUI();
    }

    @Override
    public void start() {

    }

    @Override
    public void printOutput(String text) {
        System.out.println(text);
    }

    public void addPerson() {
        System.out.println(text.promptName);
        String name = scanner.nextLine();
        System.out.println(text.promptSurname);
        String surname = scanner.nextLine();
        System.out.println(text.promptPatronymic);
        String patronymic = scanner.nextLine();
        System.out.println(text.promptGender);
        Gender gender = (scanner.nextLine().equals("1")) ? Gender.MALE : Gender.FEMALE;
        System.out.println(text.promptDateBirth);
        LocalDate dateBirth = inputDate();
        System.out.println(text.promptDateDeath);
        LocalDate dateDeath = inputDate();
        presenter.addPerson(new Person(name, surname, patronymic, gender, dateBirth, dateDeath));
    }

    public LocalDate inputDate() {
        String input = scanner.nextLine();
        if (input.isEmpty())
            return null;
        return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
