package FamilyTree.Tree.view;

import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.presenter.Presenter;


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
    public void start(String path, Service service, Presenter presenter) {
        header();
        while (work) {
            System.out.print("Выберите пункт Меню -> ");
            menuUi();
            String choice = scanner.nextLine();
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt, path);
        }
    }
    private void header() {
        System.out.println("\nПрограмма для работы с семейным древом");
    }
    private void menuUi() {
        System.out.println(menu.menu());
    }


    public void Finish() {
        scanner.close();
        work = false;
    }

    public void sortDateOfBirth() {
        presenter.sortDateOfBirth();
        
    }

    public void sortPatronymic() {
        presenter.sortPatronymic();
        
    }

    public void getHumansInfo() {
        presenter.getHumansInfo();
    }
    private void errorInput() {
        System.out.println("Введенно некорректное значение");
    }


    public void addHumans(){
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Введите отчество человека");
        String patronymic = scanner.nextLine();
        System.out.println("Введите год рождения человека(****)");
        String dateOfBirthString = scanner.nextLine();
        int dateOfBirth = Integer.parseInt(dateOfBirthString);
        presenter.addHumans(name, patronymic, dateOfBirthString);
    }

    public void addChildren() {
        System.out.println("Введите имя кому хотите добавить ребенка");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию кому хотите добавить ребенка");
        String patronymic = scanner.nextLine();
        System.out.println("Введите год рождения человека(****)");
        String dateOfBirthString = scanner.nextLine();
        System.out.println("Введите имя ребенка");
        String nameChildren = scanner.nextLine();
        System.out.println("Введите фамилию ребенка");
        String surnameChildren = scanner.nextLine();



    }


    public void addParent() {
        System.out.println("Введите имя кому хотите добавить родителя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию кому хотите добавить родителя");
        String patronymic = scanner.nextLine();
        System.out.println("Введите имя родителя");
        String nameParent = scanner.nextLine();
        System.out.println("Введите фамилию родителя");
        String surnameParent = scanner.nextLine();
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }


    public void saveFam(String path) {
        presenter.saveFam(path);
    }
    public void readFam(Object path) {
        presenter.readFam(path);
    }
}
