package view;

import presenter.Presenter;
import view.menu.MainMenu;

import java.util.Scanner;

/**
 * Класс ConsoleUI представляет консольный пользовательский интерфейс (UI).
 * Реализует интерфейс View, и обеспечивает взаимодействие с пользователем через консоль.
 */
public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private boolean importFileLoaded;
    private MainMenu mainMenu;


    /**
     * Создает новый объект ConsoleUI.
     * Инициализирует Scanner, устанавливает флаги работы и загрузки файла в false,
     * инициализирует главное меню и Presenter.
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        importFileLoaded = false;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }

    /**
     * Выводит текст на консоль.
     *
     * @param text текст для вывода
     */
    @Override
    public void print(String text) {
        System.out.println(text);
    }


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

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    /**
     * Проверяет веденные пользователем данные, являются ли они целыми числами
     *
     * @param line введенные данные
     * @return boolean
     */
    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) return false;
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }


    /**
     * Запускает отображение Menu
     */
    private void runMenu() {
        while (work) {
            System.out.println("[Вы работаете с семейным деревом " +
                    presenter.getHumanService().getFamilyTree().getNameFamilyTree() + "]");
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    /**
     * Загружает файл с типом Human.
     * Запрашивает у пользователя путь к файлу и передает его в Presenter для загрузки.
     * Повторяет запрос, пока файл не будет успешно загружен.
     */
    public void importFile() {
        while (!importFileLoaded) {
            System.out.println("Укажите путь к файлу типа Human для загрузки (Пример: data/ruriksTree.bin)");
            presenter.importFile(scanner.nextLine());
            if (presenter.getHumanService().getFamilyTree() != null) importFileLoaded = true;
        }
    }

    /**
     * Добавляет запись в семейное дерево.
     * Запрашивает у пользователя имя, пол и год рождения человека, и передает эти данные в Presenter для добавления записи.
     */
    public void addRecordInTree() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String gender = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String dateOfBirth = scanner.nextLine();
        presenter.addRecord(name, gender, dateOfBirth);

    }

    /**
     * Запрашивает у пользователя имя и год рождения, и выводит соответствующую запись из семейного дерева через
     * Presenter.
     */
    public void getRecordInTree() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        System.out.println(presenter.getRecord(name, year));
    }

    /**
     * Выводит все записи из семейного дерева через Presenter.
     */
    public void getAllRecord() {
        presenter.getAllRecord();
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

    /**
     * Запрашивает у пользователя имя и год рождения и выводит родителей человека через Presenter.
     */
    public void getParents() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        presenter.getParents(name, year);
    }

    /**
     * Запрашивает у пользователя тип сортировки и сортирует семейное дерево через Presenter.
     */
    public void sortTree() {
        System.out.println("""
                Выберите тип сортировки
                1. Имена по алфавиту
                2. По длине имени
                3. По дате рождения""");
        presenter.sortTree(scanner.nextLine());
    }
}
