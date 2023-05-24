package ui;

import java.util.List;
import java.util.Scanner;

import Presenter.Presenter;

public class Console implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void finish(){
        System.out.println("До скорых встреч");
        work = false;
    }

    @Override
    public void start(){
        System.out.println("Привет!");
        while (work){
            printMenu();
            execute();
        }
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
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

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    @Override
    public void addMember(){
        System.out.println("Введите имя ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию ");
        String lastName = scanner.nextLine();
        // System.out.println("Введите пол Male или Female: ");
        // Gender gender = (Gender)scanner.nextLine();
        System.out.println("Введите дату рождения");
        System.out.println("День:");
        int dayOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.println("Месяц (номер):");
        int monthOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.println("Год:");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        presenter.addMember(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);
    }

    @Override
    public void getAllMembers(){
        presenter.getAllMembers();
    }

    @Override
    public void getMembersByName(){
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        presenter.getMembersByName(name);
    }


}
