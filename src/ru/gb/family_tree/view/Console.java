package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class Console implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;


    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Greetings! Select an item from the menu: ");
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("It was nice talking to you");
        work = false;
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void addHuman() {
        System.out.println("Input name:\n");
        String name = scanner.nextLine();
        System.out.println("Input gender:\n");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Input birth date");
        System.out.println("Day:\n");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Month:\n");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Year:\n");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate birthDate = LocalDate.of(year, month, day);
        presenter.addHuman(name, gender, birthDate);
    }

    public void getByName(String name){
        presenter.getByName(name);
    }


    public boolean setWedding(long humanId1, long humanId2){
        return presenter.setWedding(humanId1, humanId2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        return presenter.setDivorce(humanId1, humanId2);
    }

    public boolean setParent(long parentId, long childId) {
        return presenter.setParent(parentId, childId);
    }

    public boolean setChild(long childId, long parentId) {
        return presenter.setChild(childId, parentId);
    }

    public void remove(long id){
        presenter.remove(id);
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
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

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
