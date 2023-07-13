package family_tree.view;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.tree.FamilyTree;
import family_tree.tree.tree_service.Tree_service;

import java.util.Scanner;

public class Menu_1 implements My_Scanner {
    Tree_service tree_service = new Tree_service();

    Scanner sc = My_Scanner.sc;
    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Сортировка по Id;
                2 - Сортировка по имени (Фамилия Имя Отчество );
                3 - Сортировка по дате рождения;
                                
                """);
    }

    public String menu_1() {
        String str;
        printMenu();
        System.out.print("Введите соответствующую цифру меню: ");
        str = sc.nextLine();
        return str;
    }
}
