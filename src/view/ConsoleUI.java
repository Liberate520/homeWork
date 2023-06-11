package view;

import presenter.Presenter;
import view.menu.MainMenu;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private boolean importFileLoaded;
    private MainMenu mainMenu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        importFileLoaded = false;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }


    @Override
    public void start() {
        System.out.println("Здравствуйте");
        while (!importFileLoaded) {
            importFile();
        }
        while (work) {
            System.out.println(treeFileImportCheckView());
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) return false;
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }


    public String treeFileImportCheckView() { //TODO надо поменять уведомления
        if (presenter.getHumanService().getFamilyTree() == null) {
            return "[Импорт файла] Укажите путь к файлу ";

        } else if (presenter.getHumanService() == null && presenter.getHumanService().getFamilyTree() != null) {
            return "[Дерево обнаружено, но не сохранено, укажите путь к файлу]";
        } else {
            return "[Вы работаете с семейным деревом " + presenter.getHumanService().getFamilyTree().getNameFamilyTree() + "]";
        }
    }

    public void importFile() {
        System.out.println("Укажите путь к файлу для загрузки");
        presenter.importFile(scanner.nextLine());
        if (presenter.getHumanService().getFamilyTree() != null) importFileLoaded = true;
    }

    public void addRecordInTree() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String gender = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String dateOfBirth = scanner.nextLine();
        presenter.addRecord(name, gender, dateOfBirth);

    }

    public void getRecordInTree() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        System.out.println(presenter.getRecord(name, year));
    }

    public void getAllRecord() {
        presenter.getAllRecord();
    }

    public void finish() {
        System.out.println("Программа остановлена");
        presenter.saveFile();
        work = false;
    }

    public void getParents() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        presenter.getParents(name, year);
    }
}
