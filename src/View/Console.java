package View;

import Model.Human.Human;
import Model.Human.Sex;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scan;
    private Menu menu;
    private boolean work;

    public Console() {
        work = true;
        scan = new Scanner(System.in);
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (work){
            System.out.println(menu.print());
            String choice = scan.nextLine();
            if (check(choice)){
                menu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }

    private boolean check(String text){
        return  text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize()
                && Integer.parseInt(text) > 0;
    }

    public void fail() {
        System.out.println("Неверный ввод!");
    }

    public void getHumanList(){
        presenter.getHumanList();
    }

    public void addHuman(){
        System.out.println("Введите имя: ");
        String firstName = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scan.nextLine();
        System.out.println("Введите дату рождения (пример: 2016-08-16): ");
        String birthDate_str = scan.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDate_str);
        System.out.println("Введите дату смерти (пример: 2056-08-16): ");
        String deathDate_str = scan.nextLine();
        LocalDate deathDate = LocalDate.parse(deathDate_str);
        presenter.addHuman(firstName,lastName, birthDate, deathDate);
    }

    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByBirthday(){
        presenter.sortByBirthday();
    }

    public void finish(){
        work = false;
    }

}
