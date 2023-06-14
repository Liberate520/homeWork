package HW.view;

import HW.model.human.Human;
import HW.model.human.enumerate.Sex;
import HW.model.tree.FamilyTree;
import HW.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI(FamilyTree<Human> tree){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter(tree);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Hello");
        while (work) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1){
                System.out.println("Input error");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void finish() {
        System.out.println("Good buy. Hope to see you soon!)");
        work = false;
    }

    public void addNote(){
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();

        presenter.addNote(name, surname);
    }

    public void getNote(){
        System.out.println("Show member");
        System.out.println("Type name");
        String name = scanner.nextLine();
        System.out.println("Type surname");
        String surname = scanner.nextLine();
        System.out.println(presenter.getNote(name, surname));
    }

    public void getAllNote(){
        System.out.println("All your notes:");
        System.out.println(presenter.getAllNote());
    }
}
