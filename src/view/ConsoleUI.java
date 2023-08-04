package view;

import model.person.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start(){
        System.out.printf("Начало работы\n");
        while (work){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            if (checkChoice(choice)){
                int choiceInt = Integer.parseInt(choice);
                menu.execute(choiceInt);
            }else errorInput();
        }
    }

    private boolean checkChoice(String choice){
        int size = menu.size();
        if (choice.matches("/[1-{size}]/")) return true;
        else return true;
    }

    private void errorInput() {
        System.out.println("Введено некорректное значение\n");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void finish() {
        scanner.close();
        System.out.println("Завершение работы");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void addPerson(){
        System.out.println("Введите данные:");
        System.out.println("Имя:");
        String firstName = scanner.nextLine();
        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println("Пол:");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Дата рождения гггг-мм-дд");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Дата смерти гггг-мм-дд или -");
        String deathDateString = scanner.nextLine();
        LocalDate deathDate;
        if (deathDateString.matches("-")) deathDate = null;
        else deathDate = LocalDate.parse(deathDateString);

        presenter.addPerson(firstName, lastName, gender, birthDate, deathDate);

    }
}
