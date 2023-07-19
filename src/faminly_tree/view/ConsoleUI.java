package faminly_tree.view;

import faminly_tree.presenter.Presenter;
import faminly_tree.view.add_human.AddHuman;
import faminly_tree.view.commands.FirtsMenu;
import faminly_tree.view.commands.MainMenu;
import faminly_tree.view.examination.Exam;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    boolean work;
    boolean flagToAddHuman;
    private MainMenu mainMenu;
    private FirtsMenu firtsMenu;
    private String pathRemember;
    private Exam exam;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        flagToAddHuman = true;
        mainMenu = new MainMenu(this);
        firtsMenu = new FirtsMenu(this);
        exam = new Exam();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        Hello();
        while (work) {
            System.out.println();
            System.out.println(mainMenu.getMenu());
            int choice = takeChoice(mainMenu.getSize());
            if (choice != -1) mainMenu.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", mainMenu.getSize());
        }
    }

    private void Hello() {
        System.out.println(firtsMenu.getMenu());
        int choice = takeChoice(firtsMenu.getSize());
        if (choice != -1) firtsMenu.execute(choice);
        else {
            System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", firtsMenu.getSize());
            Hello();
        }
    }
    //не уверена в корректности этого метода, то что он пустой, но мне нужно чтобы он пропустил вперед без выполнения каких-либо действий
    public void startNewProject() {
    }
    public void downlandProject() {
        print("Укажите имя файла:");
        String name = scanner.nextLine();
        if (!name.contains(".out")) name = name + ".out";
        this.pathRemember = name;
        if (!downland(name)) {
            System.out.println("Файл не найден");
            downlandProject();
        }
    }
    public boolean downland(String path) {
        return presenter.downland(path);
    }
    private int takeChoice(int size) {
        String line = scanner.nextLine();
        int choice = exam.itsNumber(line);
        if ((choice > size) || (choice <= 0)) return -1;
        return choice;
    }
    public void addHuman() {
        flagToAddHuman = true;
        presenter.addHuman();
        AddHuman addHuman = new AddHuman(this);
        while(flagToAddHuman) {
            System.out.println(addHuman.getChoice());
            int choice = takeChoice(addHuman.getSize());
            if (choice != -1) addHuman.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", addHuman.getSize());
        }
    }
    public void addConnection() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        print("Укажите id родителя, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int parentID = findHumanID();
        if (parentID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        print("Укажите id ребенка, имеющегося в древе, для которого вы хотите установить родственную связь: ");
        int childID = findHumanID();
        if (childID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        boolean flag = presenter.connection(parentID, childID);
        if (flag == false) print("Человека с таким id нет в семейном древе");
        else print("Успешно изменена родственная связь");
    }
    public void showAllTree() {
        presenter.showAllTree();
    }
    public void sortByAge() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        presenter.sortByAge();
    }
    public void sortByID() {
        presenter.sortByID();
    }
    public void sortByName() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        presenter.sortByName();
    }
    public void finishAfterWork() {
        print("Вы хотите сохранить работу над проектом?");
        String answer = scanner.nextLine();
        if (answer.equals("да") || answer.equals("yes")) {
            if (pathRemember != null) {
                if (!save(pathRemember)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            } else {
                print("Введите имя файла на английском: ");
                String name = scanner.nextLine().toLowerCase();
                name = name + ".out";
                if (!save(name)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            }
        }
        System.out.println("До свидания!");
        work = false;
    }
    public void finishBeforeWork() {
        System.out.println("До свидания!");
        work = false;
    }
    public boolean save(String name) {
        return presenter.save(name);
    }
    private int findHumanID() {
        showAllTree();
        String id = scanner.nextLine();
        return exam.itsNumber(id);
    }
    public void nextOfKin() {
        if (presenter.treeIsEmpty() == 0) {
            print("Дерево не заполнено");
            return;
        }
        print("Укажите id человека, имеющегося в древе, для которого вы хотите вывести ближайших родственников: ");
        int humanID = findHumanID();
        if (humanID == -1) {
            print("Ошибка ввода числа");
            return;
        }
        presenter.nextOfKin(humanID);
    }
    public void returnToFirstMenu() {
        Hello();
    }
    public void finishAddHuman() {
        flagToAddHuman = false;
        presenter.addHumanToTree();
    }
    public Presenter getPresenter() {
        return presenter;
    }

    public void finish() {
        flagToAddHuman = false;
    }
}
