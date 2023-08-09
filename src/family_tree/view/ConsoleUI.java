package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean flag;
    private TreeMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new TreeMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println(menu.menu());
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения (год-месяц-день):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Введите дату смерти (год-месяц-день):");
        String dateOfDeath = scanner.nextLine();
        System.out.println("Введите пол (Female, Male):");
        String gender = scanner.nextLine();
        LocalDate birthDate = null;
        LocalDate deathDate = null;
        try {
            birthDate = LocalDate.parse(dateOfBirth);
            deathDate = LocalDate.parse(dateOfDeath);
        } catch (DateTimeParseException e) {

        } finally {
            presenter.addHuman(name, birthDate, deathDate, Gender.valueOf(gender));
        }

    }

    public void addMother(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID матери");
        int motherID = scanner.nextInt();
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        presenter.setMother(motherID, childID);
    }

    public void addFather(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID отца");
        int fatherID = scanner.nextInt();
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        presenter.setFather(fatherID, childID);
    }

    public void showParentName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID ребенка");
        int childID = scanner.nextInt();
        System.out.println(presenter.showParentName(childID));
    }

    public void showChildName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID человека");
        int id = scanner.nextInt();
        System.out.println(presenter.showChildName(id));

    }

    public void showSibling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID человека");
        int id = scanner.nextInt();
        System.out.println(presenter.showSiblingName(id));
    }

    public void findHumanByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID");
        int requiredID = scanner.nextInt();
        System.out.println(presenter.findByID(requiredID));
    }

    public void findHumanByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String requiredHuman = scanner.nextLine();
        System.out.println(presenter.findByName(requiredHuman));
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void  sortByGender() {
        presenter.sortByGender();
    }

    public void showFamilyTree() {
        presenter.showFamilyTree();

    }
    public void finish() {
        flag = false;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
