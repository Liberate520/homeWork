package FamilyTree.view;

import FamilyTree.model.Person.Gender;
import FamilyTree.model.Person.Person;
import FamilyTree.presenter.Presenter;

import java.security.Principal;
import java.time.LocalDate;
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

    private void printMenu(){
        System.out.println(menu.print());
//        System.out.println("1. Добавить человека");
//        System.out.println("2. Показать дерево");
//        System.out.println("3. Отсортировать по имени");
//        System.out.println("4. Отсортировать по возрасту");
//        System.out.println("5. Сохранить дерево в файл");
//        System.out.println("6. Загрузить дерево из файла");
//
//        System.out.println("0. Загрузить дерево из файла");
    }

        private void scanMenu(){
        int choise  = Integer.parseInt(scanner.nextLine());
        if (choise > 0 && choise < menu.size()){
            menu.execute(choise);
        }
        else {
            System.out.println("Такого пункта нет в списке.");
        }
//        switch (choise){
//            case "1": addPerson();  break;
//            case "2": getTree();    break;
//            case "3": sortByName(); break;
//            case "4": sortByAge();  break;
//            case "5": saveTree();   break;
//            case "6": loadTree();   break;
//            case "0": finish();     break;
//        }
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

    public void getTree()      { presenter.getTree(); }
    public void sortByName()   { presenter.sortByName(); }
    public void sortByAge()    { presenter.sortByAge(); }
    public void saveTree()     { presenter.saveTree();   }
    public void loadTree()     { presenter.loadTree();    }

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
