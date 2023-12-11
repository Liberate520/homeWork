package my_family_tree.view;

import my_family_tree.model.human.Gender;
import my_family_tree.model.writer.Writable;
import my_family_tree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Начинаем работу");
        while (work){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu() {
        int choice = checkInt();
        try {
            if ( choice > 0 && choice <= menu.size()){
                menu.execute(choice);
            }
            else error();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void error() {
        System.out.println("Вы ввели неверное значение");
    }

    public void finish() {
        work = false;
    }
    private int checkInt(){
        int value = 0;
        boolean flag = true;
        while (flag){
            String string = scanner.nextLine();
            if(string.matches("[0-9]+")){
                value = Integer.parseInt(string);
                flag = false;
            } else { System.out.println("Вы ввели неверное значение"); }
        }
        return value;
    }

    private int checkId(){
        int id = 0;
        boolean flag = true;
        while (flag){
            id = checkInt();
            if(presenter.checkId(id)) {
                flag = false;
            }
            else {System.out.println("Вы ввели неверное значение");}
        }
        return id;
    }



    public void setDeathDate(){
        presenter.getTreeInfo();
        System.out.println("Введите ID: ");
        int iD = checkId();
        System.out.println("Введите дату смерти в формате YYYY-MM-DD: ");
        LocalDate deathday = LocalDate.parse(scanner.nextLine());
        presenter.setDeathDate(iD, deathday);
    }
    public void save(){
        presenter.save();
    }

    public void setWritable(Writable writable){
        presenter.setWritable(writable);
    }

    public void load(){
        try{
            presenter.load();
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void sortByYear() {
        presenter.sortByYear();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    public void addHumanToTheFamily() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male/Female: ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите дату рождения в формате YYYY-MM-DD: ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        presenter.addHumanToTheFamily(name, gender, birthday);
    }


    public void wedding() {
        presenter.getTreeInfo();
        System.out.println("Введите ID 1");
        int sp1 = checkId();
        System.out.println("Введите ID 2");
        int sp2 = checkId();
        presenter.wedding(sp1, sp2);
    }

    public void addParents() {
        presenter.getTreeInfo();
        System.out.println("Введите ID родителя");
        int par = checkId();
        System.out.println("Введите ID ребенка");
        int chil = checkId();
        presenter.addParents(par, chil);

    }

    private void printMenu(){
        System.out.println(menu.print());
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
}
