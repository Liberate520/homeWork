import familytree.model.Familytree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.view.FamilyTreeView;
import familytree.view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        Familytree familytree = new Familytree();
        List<Person> people = new ArrayList<>();
        FamilyTreeView familyTreeView = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familytree, familyTreeView,people);


        int choice;
        do {
            menuView.showMenu();
            choice = menuView.getUserChoice();

            switch (choice) {
                case 1:
                    familyTreeView.addPeople(people);
                    break;
                case 2:
                    familyTreeView.printPeople(people);
                    break;
                case 3:
                    familyTreeView.sortPeopleByName(people);
                    break;
                case 4:
                    familyTreeView.sortPeopleSurName(people);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите попытку.");
            }
        } while (choice != 0);

        menuView.close();
    }



}
