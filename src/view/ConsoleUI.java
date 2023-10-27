package view;

import model.FamilyTree.FamilyTree;
import model.Service.Service;
import model.creature.Creature;
import model.creature.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private MainMenu mainMenu;
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Service service;

    public ConsoleUI() {
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    public ConsoleUI(FamilyTree<Creature> tree) {
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, new Service(tree));
        work = true;
    }


    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (work) {
            System.out.println(mainMenu.menu());
            String line = scanner.nextLine();
            // метод проверки на валидность
            int choice = Integer.parseInt(line);
            mainMenu.choice(choice);
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getCreatureList() {
        presenter.getCreatureListInfo();
    }

    public void addCreature() {
        System.out.println("Укажите имя");
        //метод проверки данных на валидность
        String name = scanner.nextLine();
        System.out.println("Укажите пол (male, female)");
        //метод проверки данных на валидность
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Укажите дату рождения (yyyy-mm-dd)");
//        LocalDate dataBirth = LocalDate.parse(scanner.nextLine().formatted("yyyy/mm/dd"));
        LocalDate dataBirth = LocalDate.parse(scanner.nextLine());
        //метод проверки данных на валидность
        presenter.addCreature(name, gender, dataBirth);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
