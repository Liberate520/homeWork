package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Error input";
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
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
    @Override
    public void start() {
        System.out.println("Hello!");
        while (work){
            System.out.println(menu.menu());
            execute();
            }
        }

    public void finish(){
        System.out.println("Goodbye");
        work = false;
    }

    public void addPerson(){
        System.out.println("Add person's name");
        String name = scanner.nextLine();
        System.out.println("Add person's gender");
        String genderString = scanner.nextLine();
        System.out.println("Add person's birth year");
        String birthYear = scanner.nextLine();
        System.out.println("Add person's birth month");
        String birthMonth = scanner.nextLine();
        System.out.println("Add person's birth date");
        String birthDate = scanner.nextLine();
        System.out.println("Add person's father");
        long idFather = Long.parseLong(scanner.nextLine());
        System.out.println("Add person's mother");
        long idMother = Long.parseLong(scanner.nextLine());
        presenter.addPerson(name, genderString, birthYear, birthMonth, birthDate, idFather, idMother);
    }


    public void addChild(){
        System.out.println("Add parent's Id");
        long idParent = Long.parseLong(scanner.nextLine());
        System.out.println("Add child's Id");
        long idChild = Long.parseLong(scanner.nextLine());
        presenter.addChild(idParent, idChild);
    }

    public void addParent(){
        System.out.println("Add child's Id");
        long idChild = Long.parseLong(scanner.nextLine());
        System.out.println("Add parent's Id");
        long idParent = Long.parseLong(scanner.nextLine());
        presenter.addParent(idParent, idChild);
    }
    public void sortByName(){
        presenter.sortByName();
    }

    public void setWedding() {
        System.out.println("If you want to marry persons: ");
        System.out.println("Add first spouse ID");
        long idFirstSpouse = Long.parseLong(scanner.nextLine());
        System.out.println("Add second spouse ID");
        long idSecondSpouse = Long.parseLong(scanner.nextLine());
        presenter.setWedding(idFirstSpouse,idSecondSpouse);
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
        if (numCommand < menu.getSize()+1){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }


    public void getSiblings() {
        System.out.println("Write sibling's ID");
        String sibID = scanner.nextLine();
        System.out.println(presenter.getSiblings(sibID));

    }

    public void getInfo() {
        System.out.println(presenter.getInfo());
    }

    public void save() throws IOException {
        System.out.println("Add file's name");
        String filename = scanner.nextLine();
        presenter.save(filename);
        System.out.println("File is saved as "+ filename);
    }

    public void load() throws ClassNotFoundException, IOException {
        System.out.println("Write file's name");
        String filename = scanner.nextLine();
        presenter.load(filename);
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void setDivorce() {
        System.out.println("If you want to divorce persons: ");
        System.out.println("Add first spouse ID");
        long idFirstSpouse = Long.parseLong(scanner.nextLine());
        System.out.println("Add second spouse ID");
        long idSecondSpouse = Long.parseLong(scanner.nextLine());
        presenter.setDevorce(idFirstSpouse,idSecondSpouse);
    }

    public void removePerson() {
        System.out.println("If you want remove person:");
        System.out.println("Add person's Id");
        long idPerson = Long.parseLong(scanner.nextLine());
        presenter.removePerson(idPerson);
    }
}
