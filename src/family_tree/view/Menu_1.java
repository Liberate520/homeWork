package family_tree.view;
import family_tree.infrastucture.My_Scanner;
import family_tree.tree.FamilyTree;
import family_tree.tree.tree_service.Tree_service;

import java.util.Scanner;

public class Menu_1 implements My_Scanner {
    Tree_service ts = new Tree_service();

    Scanner sc = My_Scanner.sc;
    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Сортировка по Id;
                2 - Сортировка по имени (Фамилия Имя Отчество );
                3 - Сортировка по дате рождения;
                                
                """);
    }

    public FamilyTree menu_1(FamilyTree family_tree) {
        String str;
        printMenu();
        System.out.print("Введите соответствующую цифру меню: ");
        str = sc.nextLine();
        if (str.equals("1")) {
            family_tree = ts.sortById(family_tree);
        }
        if (str.equals("2")) {
            family_tree = ts.sortByName(family_tree);
        }
        if (str.equals("3")) {
            family_tree = ts.sortByAge(family_tree);
        }
        return family_tree;
    }
}
