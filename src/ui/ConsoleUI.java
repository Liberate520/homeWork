package ui;

import java.util.Scanner;

import Presenter.Presenter;
import menu.AddAncestry;
import menu.Command;
import menu.LoadMenu;
import menu.SaveMenu;
import menu.ShowAllMenu;
import menu.StartMenu;

public class ConsoleUI implements View {
    private Presenter presenter;
    // private Scanner scanner;
    private Command command;

    public ConsoleUI() {
        // scanner = new Scanner(System.in);
        command = new StartMenu(this);
        
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
    public void start(Presenter presenter) {
        Integer work= 10;
        setPresenter(presenter);
        while (work>0) {
            switch (work) {
                case (1): {
                    command = new AddAncestry(this);
                    break;
                }
                case (10): {
                    command = new  StartMenu(this);
                    break;
                }
                case (2): {
                    command = new ShowAllMenu(this);
                    break;
                }
                case (21): {
                    presenter.sortByName();
                    print(presenter.showAllPerson());
                    break;
                }
                case (22): {
                    presenter.sortByDateOfBirth();
                    print(presenter.showAllPerson());
                    break;
                }
                case (23):
                case (20): {
                    command = new  StartMenu(this);
                    break;
                }
                case (3): {
                    command = new SaveMenu(this);
                    break;
                }
                case (31): {
                    presenter.save();
                    command = new  StartMenu(this);
                    break;
                }
                case (30): 
                case (32): {
                    command = new  StartMenu(this);
                    break;
                }
                case (4): {
                    command = new LoadMenu(this);
                    break;
                }
                case (41): {
                    presenter.load();
                    command = new  StartMenu(this);
                    break;
                }
                case (40):
                case (42): {
                    command = new  StartMenu(this);
                    break;
                }
            }
            work=command.execute();
        }
    }

    public void load() {
        load();
        print(presenter.showAllPerson());
    }
    public String showPerson(Integer chois){
        return presenter.showPerson(chois);
    }
    public void showAllPerson(){
        print(presenter.showAllPerson());
    }
    public  void addFater(Integer cur,Integer fat){
        presenter.addFater(cur, fat);
    }
    public  void addMother(Integer cur,Integer mot){
        presenter.addMother(cur, mot);
    }
    public  void addChild(Integer cur,Integer chil,Integer delChil){
        System.out.println("----------------");
        presenter.addChild(cur, chil, delChil);
    }
    public String сhildrentoSring(Integer cur){
        return presenter.сhildrentoSring(cur);
    }

}
