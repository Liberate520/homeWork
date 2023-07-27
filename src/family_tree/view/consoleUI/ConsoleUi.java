package family_tree.view.consoleUI;

import family_tree.model.gender.Gender;
import family_tree.presenter.Presenter;
import family_tree.view.View;
import family_tree.view.consoleUI.menu.Menu;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View {

    private Presenter presenter;
    private Menu menu;
    private boolean working;
    private boolean workingMainMenu;
    private Scanner scanner;

    public ConsoleUi() {
        presenter = new Presenter(this);
        menu = new Menu(this);
        working = true;
        workingMainMenu = true;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while(workingMainMenu) {
            menu.openMainMenu();
        }
        while (working) {
            menu.openMenuWorkWithTree();
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void createTreeOfPerson() {
        presenter.createTreeOfPerson();
    }

    public void createTreeOfDog() {
        presenter.createTreeOfDog();
    }

    public void finish() {
        working = false;
    }
    public void finishMainMenu() {
        workingMainMenu = false;
    }

    public Menu getMenu() {
        return menu;
    }

    public void addItem(String name,
                        LocalDate birthday,
                        LocalDate dayOfDeath,
                        Gender gender) {
        presenter.addItem(name, birthday, dayOfDeath, gender);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void printTree()
    {
        presenter.printTree();
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void readTreeFromFile() {
        presenter.readTreeOfPersonFromFile();
    }

    public void saveTree() {
        presenter.saveTree();
    }
}
