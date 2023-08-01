package study_group.view;

import study_group.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;
    public ConsoleUI(){
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    private boolean checkChoice(String choice) {
        if (choice.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    @Override
    public void start() {
        System.out.println("Приветствую, путник!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            //TODO проверка на виладность
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);

            }
        }


    private void errorInput() {
        System.out.println("Введенно некорректное значение");
    }

    public void finish() {
        scanner.close();
        work = false;

    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getStudentListInfo() {
        presenter.getInfo();
    }

    public void addStudent(){
        System.out.println("Укажите имя студента");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст студента");
        String ageString = scanner.nextLine();
        // метод проверки на валидность. Если false вызвать errorInput()
        int age = Integer.parseInt(ageString);
        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
