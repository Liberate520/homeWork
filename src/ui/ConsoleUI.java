package ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Presenter.Presenter;


public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;
    private Integer parent = 0;
    private Integer child = 0;

    public ConsoleUI() {  
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
        String temp;
        Integer chois;
        scanner = new Scanner(System.in);
        setPresenter(presenter);
        menu = new MenuStart(this);
        work = true;
        while (work){
            print(menu.printMenu());
            if (checkInput(temp=scanner.next(), menu.getCommands().size()+1)){
                chois=Integer.parseInt(temp);
                if (chois==0) chois=menu.getCommands().size();
                menu.execute(chois);
            } else {
                print("Wrong command number.");
            }
        }
    }

    public void load() {
        presenter.load();
        print(presenter.showAllPerson());
    }
    public void save() {
        presenter.save();
        print(presenter.showAllPerson());
        print("Данные сохранены");
    }
    
    // public String showPerson(Integer chois){
    //     return presenter.showPerson(chois);
    // }
    // public void showAllPerson(){
    //     print(presenter.showAllPerson());
    // }
    public  void addChild(){
        String temp = presenter.showAllPerson();
        print("\nВыберете ребенка для добавления или 0 для выхода:\n");
        print(temp);
        String[] words=temp.split("\n");
        if (checkInput(temp=scanner.next(), words.length-1)){
            child=Integer.parseInt(temp)-1;
        } else {
            print("Wrong command number.");
        }
        presenter.addChild(parent, child, null);
    }    
    public  void delChild(){
        String temp = presenter.сhildrentoSring(parent);
        print("\nВыберете ребенка для удаления или 0 для выхода:\n");
        print(temp);
        String[] words=temp.split("\n");
        if (checkInput(temp=scanner.next(), words.length-1)){
            child=Integer.parseInt(temp)-1;
        } else {
            print("Wrong command number.");
        }
        presenter.addChild(parent, null, child);
    }
    public void сhildrentoSring(){
        print("Персонаж:\n");
        print(presenter.showPerson(parent));
        print("Список детей:\n");
        print(presenter.сhildrentoSring(parent));
    }
    private Boolean checkInput(String text, Integer com){
        if (text.matches("[0-9]+") && com>=Integer.parseInt(text) && Integer.parseInt(text)>=0) {
            return true; 
        } else {
            return false;
        }
    }
    public void choisParent(){
        String temp = presenter.showAllPerson();
        print("\nВыберете родителя или 0 для выхода:\n");
        print(temp);
        String[] words=temp.split("\n");
        if (checkInput(temp=scanner.next(), words.length-1)){
            parent=Integer.parseInt(temp)-1;
        } else {
            print("Wrong command number.");
        }
    }

    public void SortPerson(){
        Integer chois=5;
        String temp;
        while (chois!=3 || chois!=0) {
            switch (chois) {
                case (1): {
                    presenter.sortByName();
                    break;
                }
                case (2): {
                    presenter.sortByDateOfBirth();
                    break;
                }
                case (3):
                case (0): {
                    return ;
                    // break;
                }
            } 
            print(presenter.showAllPerson());
            print("\nВыберете пункт меню:\n");
            print("\n1. Сортировка по имени\n2. Сортировка по году рождения\n3. Выход"); 
            if (checkInput(temp=scanner.next(), 3)){
                chois=Integer.parseInt(temp);
            }  
        }
    }

    public void ChangMenuAncestry(){
        menu = new MenuAddAncestry(this); 
    }
    public void Exit(){
        print("\nДо встречи!\n");
        work=false;
    }
    public void ExitAncestry(){
        menu = new MenuStart(this);
    }
}
