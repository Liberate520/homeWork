package family_tree.view;

import family_tree.presenter.*;
import family_tree.model.human.*;

import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleUI implements View {

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
    public void start() {
        System.out.println("Добро пожаловать!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            // нужна проверка на валидность введенного числа
            int numChoise = Integer.parseInt(choice);
            menu.execute(numChoise);

            // System.out.println("Выберите действие:\n" +
            // "1. Добавить запись" +
            // "2. Вывести все древо" +
            // "3. Сортировка по имени" +
            // "4. Сортировка по дате рождения" +
            // "5. Завершить работу");
            // String choice = scanner.nextLine();
            // switch (choice) {
            //     case "1":
            //         addHuman();
            //         break;
            //     case "2":
            //         getInfo();
            //         break;
            //     case "3":
            //         sortByName();
            //         break;
            //     case "4":
            //         sortByBirthDate();
            //         break;
            //     case "5":
            //         finish();
            //         break;
            }
        }
    

    public void addHuman() {
        System.out.println("Введите id:");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пол ('Male'/'Female'):");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        // System.out.println("Введите имя отца:");
        // String father = scanner.nextLine();
        // System.out.println("Введите имя матери:");
        // String mother = scanner.nextLine();
        // LocalDate birthDate = LocalDate.parse(birthDate);
        // presenter.addHuman(id, name, gender, birthDate, father, mother, wife, husband);
        presenter.addHuman(id, name, gender, birthDate);
    }

    public void getInfo(){
        presenter.getInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void finish() {
        System.out.println("Счастливо!");
        work = false;
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
