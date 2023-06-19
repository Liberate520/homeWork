package tree.view;

import tree.presenter.Presenter;
import tree.model.human.Gender;

import java.io.IOException;
import java.util.Scanner;

public class UserUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private UserMenu userMenu;

    public UserUI(Presenter presenter) {
        scanner = new Scanner(System.in);
        work = true;
        userMenu = new UserMenu(this);
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Превет!");
        while (work) {
            System.out.println(userMenu.printMenu());
            inputChoice();
        }
    }

    private void inputChoice() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkLine(line)) {
            userMenu.execute(Integer.parseInt(line));
        } else {
            System.out.println("Ошибка ввода!");
        }
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= userMenu.sizeMenu();
    }

    public void addHuman(){
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String gender = scanner.nextLine();
        System.out.println("Укажите отца");
        String father = scanner.nextLine();
        System.out.println("Укажите мать");
        String mother = scanner.nextLine();
        presenter.addHuman(name, Gender.valueOf(gender), father, mother);
        System.out.println(name + " добавлен");
    }

    public void removeHumanFromTree() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        if (presenter.removeHumanFromTree(name)) {
            System.out.println(name + " был удален из семейного дерева");
        } else {
            System.out.println("Такого " + name + " нет в дереве");
        }
    }

    public void findHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println(presenter.findHuman(name));
    }

    public void finish() {
        System.out.println("Работа закончена");
        work = false;
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        System.out.println("Файл отсортирован по имени");
    }

    public void sortByChild() {
        presenter.sortByChild();
        System.out.println("Файл отсортирован по количеству детей");
    }

    public void saveFile() throws IOException {
        presenter.saveFile();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        presenter.loadFile();
    }

    public void addParent() {
        System.out.println("Введите имя ребенка");
        String child = scanner.nextLine();
        System.out.println(("Введите имя родителя"));
        String parent = scanner.nextLine();
        if (presenter.addParent(child, parent)) {
            System.out.println("Ребенку " + child + " добавлен родитель " + parent);
        } else {
            System.out.printf("Ребенок %s или Родитель %s отсутствует в дереве\n", child, parent);;
        }
    }

    public void isDirectDescendant() {
        System.out.println("Введите имя human1");
        String human1 = scanner.nextLine();
        System.out.println("Введите имя human2");
        String human2 = scanner.nextLine();
        if (presenter.isDirectDescendant(human1, human2))
            System.out.printf("%s является прямым потомком %s", human1, human2);
        else System.out.printf("%s не является прямым потомком %s", human1, human2);
    }
}
