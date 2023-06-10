package tree.familyTree.view;

import tree.familyTree.presenter.Presenter;
import tree.human.Gender;

import java.util.Scanner;

public class UserUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private UserMenu userMenu;

    public UserUI() {
        scanner = new Scanner(System.in);
        work = true;
        userMenu = new UserMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void start() {
        System.out.println("Превет!");
        while (work) {
            System.out.println(userMenu.printMenu());
            inputChoice();
        }
    }

    private void inputChoice() {
        String line = scanner.nextLine();
        if (checkLine(line)) {
            userMenu.execute(Integer.parseInt(line));
        } else {
            System.out.println("Exception");
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
}
