package View;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.human.Gender;
import Model.human.Human;
import Model.tree.FamilyTree;
import Presenter.Presenter;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() { // создали конструктор класса, этот класс подписан на View, поэтому для презентера указывает этот класс
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (work) {
            printMenu();
            scanMenu();
        }
    }
    private void scanMenu() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    @Override
    public void answer(String answer) {
            System.out.println(answer);
        }

    @Override
    public void sortByAge() {
        presenter.sortByAge();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortByName() {
        presenter.sortByName();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortBySurname() {
        presenter.sortBySurname();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortById() {
        presenter.sortById();
        presenter.getHumanListInfo();
    }

    private void printMenu(){
        System.out.println(menu.print());
    }
    private void error() {
        System.out.println("Введены неверные данные");
    }

    public void finish() {
        work = false;
    }

    @Override
    public void getFamilyList() {
        presenter.getHumanListInfo();
//        System.out.println(list);
    }

    @Override
    public void load() {
            presenter.load();

    }

    @Override
    public void save() {
            presenter.save();

    }

    @Override
    public void addHuman() {
        System.out.println("Введите ID");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        System.out.println("Введите фамилию");
        String lastname = scanner.nextLine();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения 'год-месяц-день'");
        LocalDate dayOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите дату смерти 'год-месяц-день'");
        String dayStr = scanner.nextLine();
        LocalDate dayOfDeath;
        if (!(dayStr.isEmpty())) {
            dayOfDeath = LocalDate.parse(dayStr.subSequence(0, dayStr.length()));
        } else dayOfDeath = null;
        System.out.println("Введите пол (Male, Female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        Human human = new Human(id, lastname, name, dayOfBirth, gender);
        presenter.addHuman(human);
        System.out.println("Чтобы внести человека, необходимо провести сохранение!");
    }

    @Override
    public void setChild() {
        presenter.setChild();
        presenter.getHumanListInfo();
    }

    @Override
    public void findByName() {
        presenter.searchByName();
    }
}
