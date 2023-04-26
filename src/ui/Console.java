package ui;

import com.sun.tools.javac.Main;
import model.Dragons.Dragon;
import model.People.Gender;
import model.People.Person;
import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(menu.print());
            String choice = scanner.nextLine();
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

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    public void finish() {
        System.out.println("End!");
        work = false;
    }
    public void fail() {
        System.out.println("Wrong input!");
    }
    public void getTreeInfo(){
        presenter.getTreeInfo();
    }
    public void searchPersonDescendance(){
        presenter.searchPersonDescendance();
    }
    public void searchPerson(){
        presenter.searchPerson();
    }
    public void sortByName() {
        presenter.sortByName();
    }
    public void sortById(){
        presenter.sortById();
    }
    public void sortByIdReverse(){
        presenter.sortByIdReverse();
    }
    public void sortByGender(){
        presenter.sortByGender();
    }
    public void dataOutput(){presenter.dataOutput();}
    public void deserialization(){presenter.deserialization();}
    public void getInfo(){presenter.getInfo();}
}
