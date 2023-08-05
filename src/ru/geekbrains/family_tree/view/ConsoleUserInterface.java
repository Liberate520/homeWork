package ru.geekbrains.family_tree.view;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ru.geekbrains.family_tree.model.human.Sex;
import ru.geekbrains.family_tree.presenter.Presenter;

/**
 * Консольный пользовательский интерфейс, создающий посредника.
 */
public class ConsoleUserInterface implements UserInterface {
    
    /**
     * Посредник.
     */
    private Presenter presenter;

    /**
     * Меню действий.
     */
    private ActionMenu actionMenu;

    /**
     * Сканнер.
     */
    private Scanner scanner;

    /**
     * Состояние программы.
     */
    private boolean isRunning;

    /**
     * Ошибка ввода данных.
     */
    private final String INPUT_ERROR = "Неверный ввод данных.\n";

    public ConsoleUserInterface() {
        presenter = new Presenter(this);
        actionMenu = new ActionMenu(this);
        scanner = new Scanner(System.in);
        isRunning = true;
    }

    /**
     * Открывает программу и предоставляет пользователю доступ к
     * пользовательскому интерфейсу.
     */
    @Override
    public void run() {
        while (isRunning) {
            print("Введите действие");
            printActions();
            performAction();
        }
    }

    /**
     * Выводит пользователю текстовое сообщение.
     */
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    /**
     * Выводит меню действий.
     */
    private void printActions() {
        print(actionMenu.getActions());
    }

    /**
     * Выполняет введённое пользователем действие или выводит информационное
     * сообщение, если действие отсутствует в меню действий.
     */
    private void performAction() {
        String action = scanner.nextLine().toLowerCase();
        print("");
        if (!actionMenu.performAction(action)) {
            print(INPUT_ERROR);
        }
    }
    
    /**
     * Выводит семейное древо.
     */
    public void printFamilyTree() {
        presenter.printFamilyTree();
    }

    /**
     * Добавляет человека в семейное древо или выводит информационное
     * сообщение, если данные введены неверно.
     */
    public void addFamilyMember() {
        print("Введите имя человека.");
        String name = scanner.nextLine();
        if (isEmpty(name)) {
            return;
        }
        print("Введите фамилию человека.");
        String surname = scanner.nextLine();
        if (isEmpty(surname)) {
            return;
        }
        print("Введите пол человека - 'male' или 'female'.");
        String sex = scanner.nextLine();
        Sex enumerationSex;
        if (sex.equals("male")) {
            enumerationSex = Sex.MALE;
        }
        else if (sex.equals("female")) {
            enumerationSex = Sex.FEMALE;
        }
        else {
            print(INPUT_ERROR);
            return;
        }
        print("Введите год рождения человека.");
        int birthYear = Integer.parseInt(scanner.nextLine());
        print("Введите месяц рождения человека.");
        int birthMonth = Integer.parseInt(scanner.nextLine());
        print("Введите день рождения человека.");
        int birthDay = Integer.parseInt(scanner.nextLine());
        if (!isDate(birthDay, birthMonth, birthYear)) {
            return;
        }
        presenter.addFamilyMember(name, surname, enumerationSex,
                                  LocalDate.of(birthYear, birthMonth,
                                               birthDay));
    }

    /**
     * Возвращает true и выводит информационное сообщение, если строка
     * является пустой, и возвращает false, если не является.
     */
    private boolean isEmpty(String string) {
        if (string.isEmpty()) {
            print(INPUT_ERROR);
            return true;
        }
        return false;
    }

    /**
     * Возвращает true, если последовательность в формате "ДД-ММ-ГГГГ" является
     * датой, и возвращает false и выводит информационное сообщение, если не
     * является.
     */
    private boolean isDate(int day, int month, int year) {
        if (year > LocalDate.now().getYear()) {
            print(INPUT_ERROR);
            return false;
        }
        Calendar calendar = new GregorianCalendar(year, month, day);
        calendar.setLenient(false);
        try {
            calendar.set(year, month -1, day);
            calendar.getTime();
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            print(INPUT_ERROR);
            return false;
        }
    }

    /**
     * Сортирует семейное древо по имени в порядке возрастания.
     */
    public void sortFamilyTreeByName() {
        presenter.sortFamilyTreeByName();
    }

    /**
     * Сортирует семейное древо по дате рождения в порядке возрастания.
     */
    public void sortFamilyTreeByBirthDate() {
        presenter.sortFamilyTreeByBirthDate();
    }

    /**
     * Закрывает сканнер и завершает программу.
     */
    public void exit() {
        isRunning = false;
        scanner.close();
    }

}
