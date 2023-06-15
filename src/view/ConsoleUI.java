package view;

import model.members.Gender;
import model.members.Human;
import view.menu.sortMenu.SortingMenu;
import presenter.Presenter;
import view.menu.mainMenu.MainMenu;

import java.util.List;
import java.util.Scanner;

/**
 * Класс ConsoleUI представляет консольный пользовательский интерфейс (UI).
 * Реализует интерфейс View, и обеспечивает взаимодействие с пользователем через консоль.
 */
public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;


    /**
     * Создает новый объект ConsoleUI.
     * Инициализирует Scanner, устанавливает флаги работы и загрузки файла в false,
     * инициализирует главное меню и Presenter.
     */
    public ConsoleUI(Presenter presenter) {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        this.presenter = presenter;
    }

    /**
     * Для сокращения написания кода
     * @param message сообщение
     * @return Str
     */


    /**
     * Запускает консольный пользовательский интерфейс.
     * Выводит приветственное сообщение, загружает файл и запускает главное меню.
     */
    @Override
    public void start() {
        System.out.println("Здравствуйте");
        importFile();
        runMenu();
    }

    /**
     * Загружает файл с типом Human.
     * Запрашивает у пользователя путь к файлу и передает его в Presenter для загрузки.
     * Повторяет запрос, пока файл не будет успешно загружен.
     */
    public void importFile() {
        boolean importFileLoaded = false;
        while (!importFileLoaded) {
            presenter.importFile(inputLn("Укажите путь к файлу типа Human для загрузки (Пример: data/ruriksTree.bin)"));
            if (presenter.checkCreateFamilyTree()) importFileLoaded = true;
        }
    }

    /**
     * Запускает отображение Menu
     */
    private void runMenu() {
        while (work) {
            System.out.println("[Вы работаете с семейным деревом " +
                    presenter.getNameFamilyTree() + "]");
            System.out.println(mainMenu.printMenu());
            int choice = mainMenu.checkInputLineMenu(scanner.nextLine());
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    /**
     * Проверяет веденные пользователем данные, являются ли они целыми числами
     *
     * @param line входная строка
     * @return boolean
     */
    private boolean checkLineOnNumbers(String line) {
        return line.matches("[0-9]+");
    }

    private String inputLn(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private int checkDateOfBirth(String dateOfBirth) {
        return checkLineOnNumbers(dateOfBirth) ? Integer.parseInt(dateOfBirth) : -1;
    }

    /**
     * Добавляет запись в семейное дерево.
     * Запрашивает у пользователя имя, пол и год рождения человека, и передает эти данные в Presenter для добавления записи.
     */
    public void addRecord() {
        String name = inputLn("Укажите имя человека");
        int dateOfBirth = checkDateOfBirth(inputLn("Укажите год рождения"));
        Gender gender = Gender.fromStringValue(inputLn("Укажите пол"));
        if ((inputLn("Добавить родителей? 1.да 2.нет")).equals("1")) {
            presenter.addRecord(
                    name, gender, dateOfBirth,
                    inputLn("Имя отца"), checkDateOfBirth(inputLn("Год рождения отца")),
                    inputLn("Имя матери"), checkDateOfBirth(inputLn("Год рождения матери")));
        } else if (gender != null) presenter.addRecord(name, gender, dateOfBirth);
        else System.out.println("Неверно указан пол человека");
    }


    /**
     * Запрашивает у пользователя имя и год рождения, и выводит соответствующую запись из семейного дерева через
     * Presenter.
     */
    public void getRecordInTree() {
        String name = inputLn("Укажите имя");
        int yearOfBirth = checkDateOfBirth(inputLn("Укажите год рождения"));
        if (yearOfBirth == -1) System.out.println(presenter.getRecord(name, yearOfBirth));
        else System.out.println("Неверно указан год рождения");
    }

    /**
     * Выводит все записи из семейного дерева через Presenter.
     */
    public void showAllRecord() {
        List<Human> allRecord = presenter.getAllRecord();
        if (allRecord.isEmpty()) System.out.println("Семейное древо пусто.");
        else {
            System.out.println("Семейное древо:");
            allRecord.forEach(person -> System.out.println(person.getName() + " (" + person.getYearOfBirth() + ")"));
        }
    }

    /**
     * Запрашивает у пользователя имя и год рождения и выводит родителей человека через Presenter.
     */
    public void getParents() {
        String name = inputLn("Укажите имя");
        int yearOfBirth = checkDateOfBirth(inputLn("Укажите год рождения"));
        if (yearOfBirth != -1) {
            System.out.println(presenter.getParents(name, yearOfBirth).toString());
        } else System.out.println("Неверно указан год рождения");

    }

    public void getChildren() {
        String name = inputLn("Укажите имя родителя");
        int yearOfBirth = checkDateOfBirth(inputLn("Укажите год рождения"));
        if (yearOfBirth != -1) {
            System.out.println(presenter.getChildren(name, yearOfBirth).toString());
        } else System.out.println("Неверно указан год рождения");
    }

    /**
     * Запрашивает у пользователя тип сортировки и сортирует семейное дерево через Presenter.
     */
    public void sortTree() {
        System.out.println("Выберите вид сортировки");
        SortingMenu sortingMenu = new SortingMenu(this);
        System.out.println(sortingMenu.printMenu());
        int choice = sortingMenu.checkInputLineMenu(inputLn("Введите число"));
        if (choice != -1) {
            sortingMenu.execute(choice);
        } else System.out.println("Ошибка ввода");

    }

    /**
     * Завершает работу программы.
     * Сохраняет семейное дерево в файл через Presenter.
     */
    public void finish() {
        System.out.println("Программа остановлена");
        presenter.saveFile();
        work = false;
    }

    public void sortByAlphabeticalOrder() {
        presenter.sortByAlphabeticalOrder();
        System.out.println("Древо отсортировано по именам в алфавитном порядке. ");
    }

    public void sortByDateBirth() {
        presenter.sortByDateBirth();
        System.out.println("Древо отсортировано по дате рождения");
    }

    public void sortByNameLength() {
        presenter.sortByNameLength();
        System.out.println("Древо отсортировано по длине имени");
    }
}
