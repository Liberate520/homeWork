package family_tree.view;

import family_tree.infrastucture.My_Scanner;
import family_tree.tree.FamilyTree;
import family_tree.registry_office.relation.Relatives_finder;

import java.util.Scanner;

public class Menu_3 implements My_Scanner {

    Relatives_finder rf = new Relatives_finder();
    Scanner sc = My_Scanner.sc;

    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Установить родителей;
                2 - Усыновить ребенка;
                3 - Зарегистрировать брак;
                0 - Выход;
                                
                """);
    }

    public FamilyTree menu_3(FamilyTree family_tree) {
        String str = "";
        while (!str.equals("0")) {
            printMenu();
            System.out.print("Введите соответствующую цифру меню: ");
            str = sc.nextLine();
            if (str.equals("1")) {
                family_tree = rf.parents_finder(family_tree);
            }
            if (str.equals("2")) {
                family_tree = rf.adoption(family_tree);
            }
            if (str.equals("3")) {
                family_tree = rf.marriage(family_tree);
            }
        }
        return family_tree;
    }
}

