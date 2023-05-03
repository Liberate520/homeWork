package ui;

import human.Gender;
import presenter.Presenter;
import ui.menu.GenderMenu;
import ui.menu.MainMenu;

import java.util.Scanner;

public class Console implements View {
   private Presenter presenter;
   private Scanner scanner;
   private boolean work;
    private boolean addGender;
   private MainMenu mainMenu;
    private GenderMenu genderMenu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        addGender = true;
        mainMenu = new MainMenu( this);
        genderMenu = new GenderMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);

    }

    @Override
    public void start() {
        System.out.println("Привет");
        while (work){
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            mainMenu.execute(numCommand);
        }

    }
    public void finish(){
        System.out.println("Работа завершена");
        work = false;

    }
    public void finishAddGender(){
        addGender = false;

    }
    public void getHumanList(){
        presenter.getHuman();
    }
    public void addHuman(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        Gender gender = setGender();
        presenter.addHuman(name, yearOfBirth, gender);
    }
    public void addChild(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        Gender gender = setGender();
        System.out.println("Введите имя отца: ");
        String nameOfFather = scanner.nextLine();
        System.out.println("Введите имя матери: ");
        String nameOfMother = scanner.nextLine();
        presenter.addChild(name, yearOfBirth, gender, nameOfFather, nameOfMother);
    }
    public Gender setGender(){
        System.out.println("Выберете пол");
        while (addGender){
            System.out.println(genderMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
           return genderMenu.execute(numCommand);
        }
        return null;
    }
    public Gender setMale(){
        return Gender.Male;

    }
    public Gender setFemale(){
        return Gender.Female;

    }
    public void save(){
        presenter.saveFile();
    }
    public void read(){
        presenter.readFile();
    }

    @Override
    public void SetPresenter(Presenter presenter) {
        this.presenter  = presenter;

    }
}
