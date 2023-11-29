package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.human.Gender;
import presenter.Presenter;

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
        System.out.println("Загрузка файла: ");
        presenter.load();
        presenter.getHumanListInfo();
    }

    @Override
    public void save() {
        boolean saved = presenter.save();
        System.out.println("Сохранение файла: " + saved);
        presenter.getHumanListInfo();
    }

    @Override
    public void addHuman() {
        List info = new ArrayList<>();
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
        info.add(lastname);
        info.add(name);
        info.add(dayOfBirth);
        info.add(dayOfDeath);
        info.add(gender);
        presenter.addHuman(info);

    }

    @Override
    public void setChild() {
        System.out.println("Введите ID родителя: ");
        Scanner scanner = new Scanner(System.in);
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        System.out.println("Введите ID ребенка: ");
        String idChildStr = scanner.nextLine();
        int idChild = Integer.parseInt(idChildStr);
        presenter.setChild(idParent,idChild);
        presenter.getHumanListInfo();
    }



    @Override
    public void findByName() {
        System.out.println("Введите ключевое слово: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(presenter.searchByName(name));
    }
}
