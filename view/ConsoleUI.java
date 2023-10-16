package view;
import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Incorrect input";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Bye");
        work = false;
    }

    public void SortByBirthdate() {
        presenter.SortByBirthdate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input father");
        String father = scanner.nextLine();
        System.out.println("Input mother");
        String mother = scanner.nextLine();
        System.out.println("Input birth date");
        String ageString = scanner.nextLine();
        int birthdate = Integer.parseInt(ageString);
        System.out.println("Input alive status");
        String alive_status = scanner.nextLine();
        System.out.println("Input children");
        String children = scanner.nextLine();
        presenter.addHuman(name, gender,father, mother, birthdate, alive_status, children);
    }

    private void hello(){
        System.out.println("Hello");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
