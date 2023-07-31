package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        System.out.println("Welcome to GenealogicalTree app");

        while(work){
            System.out.println(menu.menu());
            System.out.println("You should choose the action");
            String choice = scanner.nextLine();
            //TODO проверка на валидность введенной цифры(getSize)

            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);

        }

    }

    public void finish() {
        System.out.println("Goodbye!");
        work = false;
    }

    public void errorInput() {
        System.out.println("You have entered the wrong number! Try again!");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyInfo() {
        presenter.getInfo();
    }

    public void addPerson(){
        System.out.print("Insert name: ");
        String name = scanner.nextLine();

        System.out.print("Insert last name: ");
        String lastName = scanner.nextLine();

        //TODO решить вопрос с перечислением

//        System.out.print("Insert name: ");
//        Gender gender = (Gender) scanner.nextLine();

        //TODO проверка на валидность
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }
}
