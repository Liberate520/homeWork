package ui;

import java.util.Scanner;
import presenter.Presenter;
import ui.menu.GenderMenu;
import ui.menu.MainMenu;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private GenderMenu genderMenu;
    public static final String PATH = "src/model/handler/saveTree.txt";
    public static final String ERROR = "\nВведено некорректное значение. Попробуйте еще раз";

    public Console() {
        scanner = new Scanner(System.in, "Cp866");
        work = true;
        mainMenu = new MainMenu(this);
        genderMenu = new GenderMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void start() {
        System.out.println("\nЗдравствуйте!");
        while (work) {
            // System.out.print("\033[H\033[2J");
            printMenu();
            String command = scanner.nextLine();
            mainMenu.execute(command);
        }

    }

    public void printMenu() {
        System.out.println(mainMenu.show());
    }

    public void addHuman() {
        System.out.println("_Добавление человека из дерева_");
        System.out.println("Введите фамилию человека:");
        String surName = scanner.nextLine();
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Введите отчество человека:");
        String fatherName = scanner.nextLine();
        System.out.println("Введите ФИО матери полностью:");
        String mother = scanner.nextLine();
        System.out.println("Введите ФИО отца полностью:");
        String father = scanner.nextLine();
        System.out.println("Введите пол человека(Male/Female):");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст человека:");
        String age = scanner.nextLine();
        if (checkTextIsNumber(age)) {
            presenter.addHuman(name, surName, fatherName, mother, father, gender, Integer.parseInt(age));
            System.out.println("\nДобавлено!!!");
        }
        else {
            errorMessage();
        }
    }

    public void removeHuman() {
        System.out.println("_Удаление человека из дерева_");
        System.out.println("Введите фамилию человека:");
        String surName = scanner.nextLine();
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Введите отчество человека:");
        String fatherName = scanner.nextLine();
        presenter.removeHuman(name, surName, fatherName);
        System.out.println("\nУдалено!!!");
    }

    public void showInfo() {
        presenter.showInfo();
    }

    public void exit() {
        System.out.println("\nДо свидания!");
        work = false;
    }

    public void showShortInfo() {
        presenter.showShortInfo();
    }

    public void showGenderStatistics() {
        if (presenter.getTreeSize() > 0) {
            System.out.println(genderMenu.show());
            String command = scanner.nextLine();
            genderMenu.execute(command);
        } else {
            System.out.println("\nДерево не содержит людей!");
        }
    }

    public void SetMale() {
        presenter.showGenderStatistics("Male");
    }

    public void SetFemale() {
        presenter.showGenderStatistics("Female");
    }

    public void save() {
        System.out.println("_Сохранение текущего дерева_");
        System.out.println("Введите путь сохранения:");
        String userPath = scanner.nextLine();
        if ((userPath.equals("")) || userPath == null) {
            userPath = PATH;
        }
        presenter.save(userPath);
    }

    public void load() {
        System.out.println("_Загрузка сохраненного дерева_");
        System.out.println("Введите путь для загрузки дерева:");
        String userPath = scanner.nextLine();
        if ((userPath.equals("")) || userPath == null) {
            userPath = PATH;
        }
        presenter.load(userPath);
    }

    private boolean checkTextIsNumber(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            // errorMessage();
            return false;
        }
    }

    private void errorMessage()
    {
        System.out.println(ERROR);
    }
}
