package ui;

import java.util.Scanner;

// import java.util.scanerner;

import Presenter.Presenter;
import model.FamilyTree;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        
    }

    @Override
    public void print(String text) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;        
    }

    @Override
    public void start(Presenter presenter) {
        setPresenter(presenter);
        presenter.load();
        ShowAllPerson();
        addAncestry();
        ShowAllPerson();
        // presenter.save();
        
    }
    public void load() {
        load();
        // ShowAllPerson();
    }
    public void ShowAllPerson(){
        System.out.print(presenter.ShowAllPerson());
    }
    public  void addAncestry(){
            Integer chois;
            Integer chois1;
            Integer chois2;
            // Person addPerson;
            // scan=erner scanner = new scanerner(System.in);
            
            System.out.println("\nВыберете персону для добавления родословной или 0 для выхода:\n");
            ShowAllPerson();
            chois=scanner.nextInt()-1;
            if (chois<0) return;
            System.out.println("cur ---- " +chois);
                // cur=listPerson.get(chois);
                // System.out.println(cur);
            
            while (true){
                System.out.println("------------");
                System.out.println("\nВыберете желаемое действие:\n1. Добавление отца\n2. Добавление матери\n3. Добавление детей\n0. Выход ");
                chois1=scanner.nextInt();
                if (chois1==0) return;
                System.out.print("\nВыберете персону для ");
                switch (chois1) {
                    case (1): {
                        System.out.println("добавления в поле отец");
                        ShowAllPerson();
                        chois2=scanner.nextInt()-1;
                        if (chois2<0) return;
                        System.out.println("cur " +chois+" fat "+chois2);
                        presenter.addFater(chois, chois2);
                        break;
                    }
                    case (2): {
                        System.out.println("добавления в поле мать");
                        break;
                    }
                    case (3): {
                        System.out.println("добавления в поле дети");
                        break;
                    }
                }
                ShowAllPerson();
                chois=scanner.nextInt()-1;
                if (chois<0) return;
        }
    }
}
