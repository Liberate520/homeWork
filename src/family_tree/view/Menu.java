package family_tree.view;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.registry_office.Reg_office;
import family_tree.tree.FamilyTree;
import family_tree.tree.tree_service.Tree_service;

import java.util.Scanner;


public class Menu implements My_Scanner {
    Menu_3 menu_3;
    Menu_1 menu_1;
    ConsoleUI consoleUI;

    public Menu() {
        menu_3 = new Menu_3();
        menu_1 = new Menu_1();
        consoleUI = new ConsoleUI();
    }

    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Вывод на экран всего древа;
                2 - Добавить нового члена;
                3 - Установить родственную связь;
                7 - Очистить древо;
                8 - Загрузить семейное древо из файла;
                9 - Сохранить семейное древо в файл;
                0 - Выход;
                
                """);
    }
    public void startMenu() {
        String str = "";
        while (!str.equals("0")) {
            printMenu();
            System.out.print("Введите соответствующую цифру меню: ");
            str = sc.nextLine();
            if (str.equals("1")){
                 String sort_by = menu_1.menu_1();
                 consoleUI.getFamilyTreeInfo(sort_by);
            }
            if (str.equals("2")){
                consoleUI.add_human();
            }
            if (str.equals("3")){
                consoleUI.set_relatives(menu_3.menu_3());
            }
            if (str.equals("7")){
                consoleUI.clearFamilyTree();
            }
            if (str.equals("8")){
                consoleUI.load_file();
            }
            if (str.equals("9")){
                consoleUI.saveFamilyTree();

            }
        }
    }

}
