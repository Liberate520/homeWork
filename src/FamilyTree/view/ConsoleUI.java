package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    private MainMenu menu;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new MainMenu(this);
    }

    private void printMenu(){ System.out.println(menu.print()); }

    private void scanMenu(){
        int choise  = Integer.parseInt(scanner.nextLine());
        if (choise > 0 && choise <= menu.size()){
            menu.execute(choise);
        }
        else {
            System.out.println("Такого пункта нет в списке.");
        }
    }

    public void addPerson() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения (гггг мм дд):");
        String birthday = scanner.nextLine();
        System.out.println("Введите пол (М/Ж):");
        String gender = scanner.nextLine();

        presenter.addPerson(name, surname, gender, birthday);
    }

    public void getTree()                   { presenter.getTree(); }
    public void sortByName()                { presenter.sortByName(); }
    public void sortByAge()                 { presenter.sortByAge(); }
    public void saveTree()   {
        System.out.println("Введите название файла:");
        String filename = scanner.nextLine();
        presenter.saveTree(filename);
    }
    public void loadTree()   {
        System.out.println("Введите название файла:");
        String filename = scanner.nextLine();
        presenter.loadTree(filename);
    }

    public void setMarriage() {
        getTree();
        System.out.println("Выберите id первого человека:");
        int id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Выберите id первого человека:");
        int id2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите дату рождения (гггг мм дд):");
        String birthday = scanner.nextLine();
        if (id1 != id2) {
            presenter.setMarriage(id1, id2, birthday);
        }
        else {
            System.out.println("Это один и тот же человек.");
        }
    }

    public void finish()       {
        System.out.println("До скорых встреч.");
        work = false;
    }

    @Override
    public void start() {
        System.out.println("Мое дерево!");
        while(work){
            this.printMenu();
            this.scanMenu();
        }
    }

    @Override
    public void answer(String str) {
        System.out.println(str);
    }
}
