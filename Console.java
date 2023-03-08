package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            } else {
                System.out.println("Не верный номер команды.");
            }
        }
    }

    private boolean checkInput(String text) {
        if (text.matches("[0-9]+")) {
            return Integer.parseInt(text) <= menu.getCommands().size();
        } else {
            return false;
        }
    }

    private void hello() {
        print("Выберите команду: ");
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void finish() {
        work = false;
    }

    public void addEntry() {
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        String gender = enterGender();
        String birthYear = enterBirthYear();
        System.out.println("Имя отца: ");
        String fatherName = scanner.nextLine();
        System.out.println("Имя матери: ");
        String motherName = scanner.nextLine();
        if (presenter.addEntry(name, gender, birthYear, fatherName, motherName)) {
            System.out.println("Добавлено в дерево.");
        }
    }

    public void showEntry() {
        print("Введите имя: ");
        presenter.showEntry(scanner.nextLine());
    }

    public void showAllEntries() {
        presenter.showAllEntries();
    }

    public void deleteEntry() {
        print("Введите имя: ");
        if (presenter.deleteEntry(scanner.nextLine())) {
            print("Удалено.");
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public String enterGender() {
        String gender = "";
        boolean validGender = false;
        while (!validGender) {
            System.out.println("Пол (м/ж): ");
            gender = scanner.nextLine();
            validGender = gender.equalsIgnoreCase("м") ||
                    gender.equalsIgnoreCase("ж");
        }
        return gender;
    }

    private String enterBirthYear() {
        String birthYear = "";
        Date birthDate = new Date(0);
        boolean birtYearIsValid = false;
        while (!birtYearIsValid) {
            System.out.println("Год рождения: ");
            try {
                birthYear = scanner.nextLine();
                birthDate = new SimpleDateFormat("yyyy").parse(birthYear);
                birtYearIsValid = true;
            } catch (ParseException e) {
                System.out.println("Не корректный год рождения");
            }
        }
        return birthYear;
    }

    public void save() {
        presenter.save();
        print("Сохранено.");
    }

    public void load() {
        presenter.load();
        showAllEntries();
    }
}