package FamilyTree_homework.view;


import FamilyTree_homework.presenter.Presenter;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private boolean work;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        work = true;
    }
    @Override
    public void start() {
        System.out.println("Начало работы");
        while (work){
            printMenu();
            choice();
        }
    }

    private void choice(){
            String choiceStr = scanner.nextLine();
            //метод проверки на валидность
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void addHuman(){
        getHumanList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения");
        String birthDate = scanner.nextLine();
        System.out.println("Введите дату смерти,если дата неизвестна введите 0");
        String deathDate = scanner.nextLine();
        System.out.println("Введите id отца");
        long idFather = Long.parseLong(scanner.nextLine());
        System.out.println("Введите id матери");
        long idMother = Long.parseLong(scanner.nextLine());
        presenter.addHuman(name, gender, birthDate,deathDate,idFather,idMother);
    }

    public void getHumanList(){
        presenter.getHumanList();
    }
    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByDeathDate() {
        presenter.sortByDeathDate();
    }
    public void save() {
        presenter.save();
    }
    public void load() {
        presenter.load();
    }
    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }
}
