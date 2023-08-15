package ru.geekbrains.family_tree.view;

import java.time.LocalDate;
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
     * Проверки действительности.
     */
    private Validations validations;

    public ConsoleUserInterface() {
        presenter = new Presenter(this);
        actionMenu = new ActionMenu(this);
        scanner = new Scanner(System.in);
        isRunning = true;
        validations = new Validations(this);
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
            print("Действие введено неверно.\n");
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
     * сообщение, если данные введены неверно или человек уже существует в
     * семейном древе.
     */
    public void addFamilyMember() {
        print("Введите имя человека.");
        String name = scanner.nextLine();
        if (!validations.getValidation(0).validate(name)) {
            return;
        }
        print("Введите фамилию человека.");
        String surname = scanner.nextLine();
        if (!validations.getValidation(0).validate(surname)) {
            return;
        }
        print("Введите пол человека - 'male' или 'female'.");
        String sex = scanner.nextLine();
        if (!validations.getValidation(1).validate(sex)) {
            return;
        }
        Sex enumerationSex;
        if (sex.equals("male")) {
            enumerationSex = Sex.MALE;
        }
        else {
            enumerationSex = Sex.FEMALE;
        }
        print("Введите дату рождения человека в формате 'ДД-ММ-ГГГГ'");
        String birthDate = scanner.nextLine();
        if (!validations.getValidation(2).validate(birthDate)) {
            return;
        }
        String [] date = birthDate.split("-");
        presenter.addFamilyMember(name, surname, enumerationSex,
                                  LocalDate.of(Integer.parseInt(date[2]),
                                               Integer.parseInt(date[1]),
                                               Integer.parseInt(date[0])));
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
     * Читает семейное древо из файла или выводит информационное сообщение,
     * если произошла ошибка при чтении данных из файла.
     */
    public void readFamilyTreeFromFile() {
        presenter.readFamilyTreeFromFile();
    }

    /**
     * Записывает семейное древо в файл или выводит информационное сообщение,
     * если произошла ошибка при записи данных в файл.
     */
    public void writeFamilyTreeToFile() {
        presenter.writeFamilyTreeToFile();
    }

    /**
     * Закрывает сканнер и завершает программу.
     */
    public void exit() {
        isRunning = false;
        scanner.close();
    }

}
