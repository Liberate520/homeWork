package ru.gb.family_tree.view;

import ru.gb.family_tree.Main;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
//    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void exitAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
//        hello();
        while (work) {
//            printMenu();
//            execute();
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            int numChoice = Integer.parseInt(choice);
//            if (numChoice >= 1 & numChoice >= menu.getSize()) {
                menu.execute(numChoice);
//            } else {
//                System.out.println("Такой команды не существует");
//            }

        }
    }

    public void addHuman() {
        System.out.println("Введите фамилию, имя и отчество");
        String fullName = scanner.nextLine();
        System.out.println("Введите пол");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения в формате 'день.месяц.год' ");
        String birthDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);

//        System.out.println("Введите дату смертия");
//        String deathDate = scanner.nextLine();
//        LocalDate dateOfDeath = LocalDate.parse(deathDate);
//        System.out.println("Введите фамилию, имя и отчество отца");
//        String father = scanner.nextLine();
//        System.out.println("Введите фамилию, имя и отчество матери");
//        String mother = scanner.nextLine();

        presenter.addHuman(fullName ,gender, dateOfBirth);
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void sortByFullName() {
        presenter.sortByFullName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void finish() {
        System.out.println("Завершение работы!");
        work  = false;
    }
    public void saveFile() {
        presenter.saveFile();
    }
    public void readFile() {
        presenter.readFile();
    }
}
