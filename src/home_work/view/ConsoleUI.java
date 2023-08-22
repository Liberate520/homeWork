package home_work.view;

import java.util.List;
import java.util.Scanner;
import home_work.model.Human;
import home_work.presenter.Presenter;

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

    public void start() {
        System.out.println("Начало работы");
        while (work) {
            System.out.println(menu.menu());
            String choiceString = scanner.nextLine();
            int choice = Integer.parseInt(choiceString);
            if (choice >= 1 && choice <= 2) {
                menu.execute(choice);
            } else {
                work = false;
            }  
        }
    }

    public void getTree() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        presenter.getTree(name);
    }

    public void addHuman() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        // System.out.println("Укажите пол человека: м/ж");
        // String gender = scanner.nextLine();
        
        Human human = new Human(name, null, null);
        presenter.addHuman(human);
        System.out.println("Добавить родителя? 1-да, 0-нет");
        String choiceString = scanner.nextLine();
        int choice = Integer.parseInt(choiceString);
        if (choice == 1) {
            System.out.println("Введите имя родителя");
            name = scanner.nextLine();
            List<Human> humanList = getHumanList();
            for (int i = 0; i < humanList.size(); i++) {
                if (humanList.get(i).getName().contains(name)) {
                    presenter.createLink(humanList.get(i), human);
                }
            }
            for (int i = 0; i < humanList.size(); i++) {
                if (!humanList.get(i).getName().contains(name)) {
                    Human parent = new Human(name, null, null);
                    presenter.createLink(parent, human);
                }
            } 
        }
        System.out.println("Добавить ребенка? 1-да, 0-нет");
        choiceString = scanner.nextLine();
        choice = Integer.parseInt(choiceString);
        if (choice == 1) {
            System.out.println("Введите имя ребенка");
            name = scanner.nextLine();
            List<Human> humanList = getHumanList();
            for (int i = 0; i < humanList.size(); i++) {
                if (humanList.get(i).getName().contains(name)) {
                    presenter.createLink(human, humanList.get(i));
                }
            }
            for (int i = 0; i < humanList.size(); i++) {
                if (!humanList.get(i).getName().contains(name)) {
                    Human child = new Human(name, null, null);
                    presenter.createLink(human, child);
                }
            }
        }
    }

    public List<Human> getHumanList() {
        return presenter.getHumanList();
    }

    public void printAnswer(String text) {
        System.out.println(text);
    }
}
