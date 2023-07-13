package family_tree.view;

import family_tree.model.infrastucture.My_Scanner;
import family_tree.model.registry_office.relation.Relatives_finder;

import java.util.Scanner;

public class Menu_3 implements My_Scanner {

    Relatives_finder relatives_finder = new Relatives_finder();
    Scanner sc = My_Scanner.sc;

    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Установить родителей;
                2 - Усыновить ребенка;
                3 - Зарегистрировать брак;
                                                
                """);
    }

    public String menu_3() {
        printMenu();
        System.out.print("Введите соответствующую цифру меню: ");
        String str = sc.nextLine();
        return str;

    }
}

