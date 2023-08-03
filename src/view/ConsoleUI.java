package view;

import model.familyTree.ConnectionType;
import model.person.Gender;
import model.person.Person;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        System.out.println(text.promptListNumber);
        Gender gender = (scanner.nextLine().equals("1")) ? Gender.MALE : Gender.FEMALE;

        System.out.println(text.promptDateBirth);
        LocalDate dateBirth = inputDate();

        System.out.println(text.promptDateDeath);
        LocalDate dateDeath = inputDate();

        presenter.addPerson(new Person(name, surname, patronymic, gender, dateBirth, dateDeath));
    }

    public void putConnection() {
        ArrayList<Person> list = this.enumeratedList();

        this.printAsEnumeratedList(list);
        System.out.println(text.promptConnectFrom);
        System.out.println(text.promptListNumber);
        Person connectFrom = list.get(Integer.parseInt(scanner.nextLine()) - 1);

        System.out.println(text.promptConnectionType);
        System.out.println(text.promptListNumber);
        String choice = scanner.nextLine();
        ConnectionType key = null;
        switch (choice) {
            case "1" -> key = ConnectionType.PARENT;
            case "2" -> key = ConnectionType.CHILD;
            case "3" -> key = ConnectionType.SIBLING;
            case "4" -> key = ConnectionType.SPOUSE;
            default -> {
                System.out.println(text.inputError);
                return;
            }
        }

        this.printAsEnumeratedList(list);
        System.out.println(text.promptConnectTo);
        System.out.println(text.promptListNumber);
        Person connectTo = list.get(Integer.parseInt(scanner.nextLine()) - 1);

        presenter.putConnection(connectFrom, key, connectTo);
    }

    public LocalDate inputDate() {
        String input = scanner.nextLine();
        if (input.isEmpty())
            return null;
        return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public ArrayList<Person> enumeratedList() {
        return presenter.enumeratedList();
    }

    public void printAsEnumeratedList(ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
    }
}
