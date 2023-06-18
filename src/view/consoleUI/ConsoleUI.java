package view.consoleUI;

import model.members.Gender;
import model.members.Human;
import model.members.Member;
import presenter.Presenter;
import view.View;
import view.consoleUI.input.InputReader;
import view.consoleUI.menu.endMenu.EndMenu;
import view.consoleUI.menu.mainMenu.MainMenu;
import view.consoleUI.menu.recordMenu.RecordMenu;
import view.consoleUI.menu.allRecordsMenu.AllRecordsMenu;
import view.consoleUI.menu.sortingMenu.SortingMenu;

import java.util.List;

/**
 * Класс ConsoleUI представляет консольный пользовательский интерфейс (UI).
 * Реализует интерфейс View, и обеспечивает взаимодействие с пользователем через консоль.
 */
public class ConsoleUI implements View {
    private Presenter presenter;
    private MainMenu mainMenu;
    private RecordMenu recordMenu;
    private InputReader input;


    /**
     * Создает новый объект ConsoleUI.
     * Инициализирует Scanner, устанавливает флаги работы и загрузки файла в false,
     * инициализирует главное меню и Presenter.
     */
    public ConsoleUI(Presenter presenter) {
//        work = true;
        mainMenu = new MainMenu(this);
        recordMenu = new RecordMenu(this);
        this.presenter = presenter;
        this.input = new InputReader();
    }


    /**
     * Запускает консольный пользовательский интерфейс.
     * Выводит приветственное сообщение, загружает файл и запускает главное меню.
     */
    @Override
    public void start() {
        System.out.println("Здравствуйте");
        importFile();
        runMainMenu();
    }

    /**
     * Загружает файл с типом Human.
     * Запрашивает у пользователя путь к файлу и передает его в Presenter для загрузки.
     * Повторяет запрос, пока файл не будет успешно загружен.
     */
    public void importFile() {
        while (!presenter.isImportFileLoaded()) {
            presenter.importFile(
                    input.inputLn("Укажите путь к файлу типа Human для загрузки (Пример: data/ruriksTree.bin)"));
        }
    }

    /**
     * Запускает отображение Menu
     */
    private void runMainMenu() {
        while (mainMenu.isRun()) {
            System.out.printf("[Вы работаете с семейным деревом [%s]\n%s",
                    presenter.getNameFamilyTree(), mainMenu.printMenu());
            int choice = mainMenu.checkInputLineMenu(input.nextLine());
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    public void runRecordMenu(Member record) {
        if (record != null) {
            RecordMenu recordMenu = new RecordMenu(this);
            System.out.println("Запись найдена.");
            while (true) {
                System.out.printf("[Человек - Имя: %s, Год рождения: %s]\nВыберите действие:\n%s",
                        record.getName(),
                        record.getYearOfBirth(),
                        recordMenu.printMenu());
                int choice = recordMenu.checkInputLineMenu(input.inputLn("Введите нужную цифру"));
                if (choice != -1) recordMenu.execute(choice);
                else System.out.println("Ошибка ввода");
                if (choice == recordMenu.size()) {
                    recordMenu.setMember(null);
                    break;
                }
            }
        } else System.out.println("Запись не найдена.");
    }

    public void runRecordsMenu(List<Human> humanList) {
        if (humanList != null) {
            AllRecordsMenu recordsMenu = new AllRecordsMenu(this);
            while (true) {
                System.out.printf("Семейное древо:\n%s",
                        recordsMenu.printMenu());
                int choice = recordsMenu.checkInputLineMenu(input.inputLn("Введите нужную цифру"));
                if (choice != -1) recordsMenu.execute(choice);
                else System.out.println("Ошибка ввода");
                if (choice == recordsMenu.size()) break;
            }
        } else System.out.println("Ваш список пуст");
    }

    public void runSortingMenu() {
        System.out.println("Выберите вид сортировки");
        SortingMenu sortingMenu = new SortingMenu(this);
        System.out.println(sortingMenu.printMenu());
        int choice = sortingMenu.checkInputLineMenu(input.inputLn("Введите число"));
        if (choice != -1) {
            sortingMenu.execute(choice);
        } else System.out.println("Ошибка ввода");

    }

    public void runEndMenu() {
        System.out.println("Файл не сохранен.\nВы уверены что хотите выйти?");
        EndMenu endMenu = new EndMenu(this);
        System.out.println(endMenu.printMenu());
        int choice = endMenu.checkInputLineMenu(input.inputLn("Введите число"));
        if (choice != -1) {
            endMenu.execute(choice);
        } else System.out.println("Ошибка ввода");
    }

    /**
     * Добавляет запись в семейное дерево.
     * Запрашивает у пользователя имя, пол и год рождения человека, и передает эти данные в Presenter для добавления записи.
     */
    public void addRecord() {
        String name = input.inputLn("Укажите имя человека");
        int yearOfBirth = input.inputDateOfBirth("Укажите год рождения");
        Gender gender = input.inputGender("Укажите пол");
        if (gender != null) {
            if ((input.inputLn("Добавить родителей? 1.да 2.нет")).equals("1")) {
                presenter.addRecord(
                        name, gender, yearOfBirth,
                        input.inputLn("Имя отца"),
                        input.inputDateOfBirth("Год рождения отца"),
                        input.inputLn("Имя матери"),
                        input.inputDateOfBirth("Год рождения матери"));
            } else {
                presenter.addRecord(name, gender, yearOfBirth);
            }
        } else System.out.println("Неверно указан пол человека");
    }


    /**
     * Запрашивает у пользователя имя и год рождения, и выводит соответствующую запись из семейного дерева через
     * Presenter.
     */
    public Member getRecord() {
        String name = input.inputLn("Укажите имя");
        int yearOfBirth = input.inputDateOfBirth("Укажите год рождения");
        if (yearOfBirth != -1) recordMenu.setMember(presenter.getRecord(name, yearOfBirth));
        else System.out.println("Неверно указан год рождения");
        return recordMenu.getMember();
    }


    public List<Human> getAllRecord() {
        return presenter.getAllRecord();

    }

    /**
     * Выводит все записи из семейного дерева через Presenter.
     */
    public void showAllRecord() {
        if (presenter.getAllRecord().isEmpty()) System.out.println("Семейное древо пусто. ");
        else {
            System.out.println("Семейное древо:");
            presenter.getAllRecord().forEach(person -> System.out.println(person.getName() + " (" + person.getYearOfBirth() + ")"));
        }
    }

    /**
     * Запрашивает у пользователя имя и год рождения и выводит родителей человека через Presenter.
     */
    public void getParents() {
        System.out.println(presenter.getParents(recordMenu.getMember().getName(),
                input.checkDateOfBirth(recordMenu.getMember().getYearOfBirth().toString())));
    }

    public void getChildren() {
        System.out.println(presenter.getChildren
                (
                        recordMenu.getMember().getName(),
                        input.checkDateOfBirth(recordMenu.getMember().getYearOfBirth().toString())
                ));
    }


    /**
     * Завершает работу программы.
     * Сохраняет семейное дерево в файл через Presenter.
     */
    public void finish() {
        System.out.println("Программа остановлена");
        mainMenu.setRun(false);
    }

    public void save() {
        if ((input.inputLn("Вы уверены? 1.да 2.нет")).equals("1"))
            presenter.saveFile();
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
