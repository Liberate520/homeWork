package HW.view;

import HW.model.dataManager.UpDownLoader;
import HW.model.human.Human;
import HW.model.tree.FamilyTree;
import HW.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI(FamilyTree<Human> tree, UpDownLoader file){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter(tree, file);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    public void printList(List<String> list){
        System.out.println(list);
    }

    @Override
    public void start() {
        print("Hello");
        while (work) {
            print(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1){
                print("Input error");
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
        print("Good buy. Hope to see you soon!)");
        work = false;
    }

    public void addNote(){
        print("Enter name");
        String name = scanner.nextLine();
        print("Enter surname");
        String surname = scanner.nextLine();

        print("Enter sex");
        String sex = scanner.nextLine();
        print("Enter date of birth");
        String dateOfBirth = scanner.nextLine();
        print("Enter date of death");
        String dateOfDeath = scanner.nextLine();
        print("Enter father name");
        String fatherName = scanner.nextLine();
        print("Enter father surname");
        String fatherSurname = scanner.nextLine();
        print("Enter mother name");
        String motherName = scanner.nextLine();
        print("Enter mother surname");
        String motherSurname = scanner.nextLine();


        presenter.addNote(name, surname, sex, dateOfBirth, dateOfDeath, fatherName, fatherSurname, motherName,motherSurname);
    }

    public void getNote(){
        print("Show member");
        print("Type name");
        String name = scanner.nextLine();
        print("Type surname");
        String surname = scanner.nextLine();
        print(presenter.getNote(name, surname));
    }

    public void getAllNote(){
        print("All your notes:");
        printList(presenter.getAllNote());
    }
    public void saver(){
        presenter.doSave();
        print ("File saved");
    }
    public void recovery(){
        presenter.doRecover();
        print ("File recovered");
    }
}
