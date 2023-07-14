package family_tree.view;
import family_tree.model.tree.tree_service.Tree_service;

import java.util.Scanner;

public class Menu_1  {
    private Scanner scanner = new Scanner(System.in);


    public String get_choice(){
        printMenu();
        System.out.print("Введите соответствующую цифру меню: ");
        return scanner.nextLine();
    }
    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Сортировка по Id;
                2 - Сортировка по имени (Фамилия Имя Отчество );
                3 - Сортировка по дате рождения;
                                
                """);
    }
}
