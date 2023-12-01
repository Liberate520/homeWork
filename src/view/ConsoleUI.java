package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Invalid value.";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void start(){
        System.out.println("Hello!");
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Good luck!");
        work = false;
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
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }


    //Methods

    public void addHuman(){
        System.out.println("Input first name:");
        String firstName = scanner.nextLine();
        System.out.println("Input second name:");
        String secondName = scanner.nextLine();
        System.out.println("Input gander (Female/Male):");
        String gender = scanner.nextLine();
        System.out.println("Input year of born:");
        String yearString = scanner.nextLine();
        System.out.println("Input month of born (number):");
        String monthString = scanner.nextLine();
        System.out.println("Input day of born:");
        String dayString = scanner.nextLine();
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        if (month >= 1 && month <= 12 && day >= 1 && day <= 31){
            if (gender.equals("Male") || gender.equals("Female")){
                presenter.addHuman(firstName, secondName, Gender.valueOf(gender), LocalDate.of(year, month, day));
            }else{
                System.out.println("Incorrect gender.");
            }
        } else {
            System.out.println("Incorrect date.");
        }
    }

    public void addChild(){
        System.out.println("Input parent's first name:");
        String parentFirstName = scanner.nextLine();
        System.out.println("Input parent's second name:");
        String parentSecondName = scanner.nextLine();
        System.out.println("Input child's first name:");
        String childFirstName = scanner.nextLine();
        System.out.println("Input child's second name:");
        String childSecondName = scanner.nextLine();
        presenter.addChild(parentFirstName, parentSecondName, childFirstName, childSecondName);
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void getHumanByFullName(){
        System.out.println("Input first name:");
        String firstName = scanner.nextLine();
        System.out.println("Input second name:");
        String secondName = scanner.nextLine();
        presenter.getHumanByFullName(firstName, secondName);
    }

    public void saveFamilyTree(){
        System.out.println("File name:");
        String fileName = scanner.nextLine();
        presenter.saveFamilyTree(fileName);
    }

    public void loadFamilyTree(){
        System.out.println("File name:");
        String fileName = scanner.nextLine();
        presenter.loadFamilyTree(fileName);
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByFullName() {
        presenter.sortByFullName();
    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);
    }
}
