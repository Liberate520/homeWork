package ru.gb.family_tree_homework.UI;

import ru.gb.family_tree_homework.family_tree_API.human.Gender;
import ru.gb.family_tree_homework.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean action;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        action = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Welcome!");
        while (action) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String choiceStr = scanner.nextLine();
        try {
            int choice = Integer.parseInt(choiceStr);
            if (choice < 1 || choice > menu.getSize()){
                error();
            } else {
                menu.execute(choice);
            }
        } catch (NumberFormatException e) {
            error();
        }
    }
    private void error(){
        System.out.println("Pick one of the available options(print the number)");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    public void finish(){
        System.out.println("Thanks for coming by");
        action = false;
    }

    public void addFamilyMember(){
        System.out.println("Input name:\n");
        String name = scanner.nextLine();
        Gender gender = null;
        System.out.println("Input gender:\n");
        while (gender == null) {
            String strGender = scanner.nextLine();
            gender = presenter.getGender(strGender);
        }
        System.out.println("Input birth date");
        System.out.println("Day:\n");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Month:\n");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Year:\n");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate birthDate = LocalDate.of(year, month, day);
        presenter.addFamilyMember(name, gender, birthDate);
    }

    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }

    public void getByName(String name){
        presenter.getByName(name);
    }

    public boolean setParent(long parentId, long childId) {
        return presenter.setParent(parentId, childId);
    }

    public boolean setChild(long childId, long parentId) {
        return presenter.setChild(childId, parentId);
    }

    public boolean setWedding(long humanId1, long humanId2){
        return presenter.setWedding(humanId1, humanId2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        return presenter.setDivorce(humanId1, humanId2);
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

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }

    public boolean saveTree(String fileName){
        return presenter.saveTree(fileName);
    }

    public boolean loadTree(String fileName){
        return presenter.loadTree(fileName);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
