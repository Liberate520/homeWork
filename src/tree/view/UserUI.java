package tree.view;

import tree.presenter.Presenter;
import tree.human.Gender;

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
        presenter.addHuman(name, Gender.valueOf(gender));
    }

    public void findHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        presenter.findHuman(name);
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
    }

    public void sortByChild() {
        presenter.sortByChild();
    }

    public void saveFile() throws IOException {
        presenter.saveFile();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        presenter.loadFile();
    }

    public void addChild() {
        System.out.println("Укажите имя (parent)");
        String human = scanner.nextLine();
        System.out.println("Укажите ребенка (child)");
        String child = scanner.nextLine();
        presenter.addChild(human, child);
    }
}
