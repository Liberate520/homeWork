package vieww;

import presenterr.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    Scanner scanner = new Scanner(System.in);
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    public ConsoleUI() {
        presenter = new Presenter(this);
        menu = new Menu(this);
        work = true;
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        presenter.loadTreeFromFile();
        while (work) {
            print(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
        // presenter.loadTreeFromFile();
        // getHumanList();
        // presenter.sortByName();
        // getHumanList();
        // presenter.sortByBirthDate();
        // getHumanList();
    }
    
    public void getHumanList(){
        presenter.getHumanList();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void exit() {
        work = false;
        print("Exiting the program...");
    }
}
