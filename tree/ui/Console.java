package ui;

import model.essences.Gender;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import presenter.Presenter;
import ui.Commands.Command;

public class Console implements View {
    private Scanner scanner;
    public Presenter presenter;
    private boolean work;
    private Menu menu;

    public Presenter getPresenter() {
        return presenter;
    }

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {

        while (work) {
            printMenu(menu.commands);
            String strChoice = scan();
            if (isNumber(strChoice))
                runChoice(strChoice);

        }
    }

    public void runChoice(String strChoice) {
        int choice = Integer.parseInt(strChoice);
        if (choice > 0 && choice < menu.commands.size())
            menu.execute(choice, menu.commands);
        else
            System.out.println("ERR => Неверный номер команды");
    }

    private boolean isNumber(String text) {
        return text.matches("[0-9]+");
    }

    private String scan() {
        return scanner.nextLine();
    }

    public void finish() {
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void viewFamily() {
        System.out.println(presenter.viewFamily());
    }

    @Override
    public void printMenu(List<Command> commList) {
        menu.printMenu(commList);
    }

    public void addCreature() {
        try {
            System.out.println("Введите имя и фамилию через пробел: ");
            String[] in = scan().split(" ");
            String firstName = in[0];
            String lastName = in[1];
            System.out.println("Выбери пол:\n" + getGendersList());
            Gender gender = getEnumGenderByString(scan());
            System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД");
            LocalDate dateBirth = LocalDate.parse(scan());
            boolean answer = presenter.addCreature(firstName, lastName, gender, dateBirth);
            if (answer)
                System.out.printf("OK => Добавлен персонаж: %s %s\n", firstName, lastName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Gender getEnumGenderByString(String code) {
        for (Gender gender : Gender.values()) {
            if (gender.name.equals(code))
                return gender;
        }
        return null;
    }

    public String getGendersList() {

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Gender[] gendersList = Gender.values();
        for (Gender gender : gendersList) {
            stringBuilder.append(++i);
            stringBuilder.append(". ");
            stringBuilder.append(gender.name());
            if (i < gendersList.length)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    // public void makeChild() {
    // System.out.println("Введите имя и фамилию ребенка через пробел:");
    // String[] in = scan().split(" ");
    // if (in.length != 2) {
    // System.out.println("ERR => Имя и фамилию нужно вводить через пробел!");
    // return;
    // }
    // String childFirstName = in[0];
    // String childLastName = in[1];

    // System.out.println("Введите имя и фамилию родителя через пробел:");
    // in = scan().split(" ");
    // if (in.length != 2) {
    // System.out.println("ERR => Имя и фамилию нужно вводить через пробел!");
    // return;
    // }

    // String parentFirstName = in[0];
    // String parentLastName = in[1];
    // presenter.validForChild(childFirstName, childLastName, parentFirstName,
    // parentLastName);
    // presenter.makeChild();
    // }

    public void readFamilyFromFile() {
        boolean answer = presenter.readFamilyFromFile();
        if (answer)
            System.out.println("OK => Состав семьи из файла загружен успешно");
        else
            System.out.println("ERR => Есть ошибки");
    }

    public void writeFamilyToFile() {
        boolean answer = presenter.writeFamilyToFile();
        if (answer)
            System.out.println("OK => Состав семьи выгружен успешно");
        else
            System.out.println("ERR => Есть ошибки");
    }

    public void viewInfoByNames() {
        System.out.println("Введите имя и фамилию через пробел: ");
        String[] in = scan().split(" ");
        String firstName = in[0];
        String lastName = in[1];
        String answer = presenter.viewInfoByNames(firstName, lastName);
        System.out.println(answer);
    }

}
