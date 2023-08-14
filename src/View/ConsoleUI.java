package View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import Presenter.Presenter;

public class ConsoleUI implements View{
    private static final String inputError = "Incorrect value";
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

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void setWedding(){
        System.out.println("Enter first id");
        long id1 = Long.parseLong(scanner.nextLine());
        System.out.println("Enter second id");
        long id2 = Long.parseLong(scanner.nextLine());
        presenter.setWedding(id1, id2);
    }

    public void setDivorse(){
        System.out.println("Enter first id");
        long id1 = Long.parseLong(scanner.nextLine());
        System.out.println("Enter second id");
        long id2 = Long.parseLong(scanner.nextLine());
        presenter.setDivorse(id1, id2);
    }
    
    public void addParents(){
        System.out.println("Enter child's id");
        long cId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter mother's id");
        long mId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter father's id");
        long fId = Long.parseLong(scanner.nextLine());
        presenter.addParents(cId, mId, fId);
    }

    public void addChild(){
        System.out.println("Enter mother's id");
        long mId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter father's id");
        long fId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter child's id");
        long cId = Long.parseLong(scanner.nextLine());
        presenter.addChild(mId, fId, cId);
    }

    public void addHuman(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter year of birth");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter month of birth");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter day of birth");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        presenter.addHuman(name, gender, dateOfBirth);
    }

    public void save(){
        Serializable serializable = presenter.getFamily();
        System.out.println("Enter file path");
        String path = scanner.nextLine();
        presenter.save(serializable, path);
    }

    public void load(){
        System.out.println("Enter file path");
        String path = scanner.nextLine();
        presenter.setFamily(presenter.toFamilyTree(presenter.load(path)));
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
        System.out.println(inputError);
    }
}
