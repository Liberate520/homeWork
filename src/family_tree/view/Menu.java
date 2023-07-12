package family_tree.view;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.registry_office.Reg_office;
import family_tree.tree.FamilyTree;
import family_tree.tree.tree_service.Tree_service;

import java.util.Scanner;


public class Menu implements My_Scanner {
    File_using file_using = new File_using();
    Menu_3 menu_3 = new Menu_3();
    Menu_1 menu_1 = new Menu_1();
    Reg_office ro = new Reg_office();
    Tree_service ts = new Tree_service();
    ConsoleUI consoleUI = new ConsoleUI();

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
//        Reg_office ro = new Reg_office();
//        Tree_service ts = new Tree_service();
        while (!str.equals("0")) {
            printMenu();
            System.out.print("Введите соответствующую цифру меню: ");
            str = sc.nextLine();
            if (str.equals("1")){
                ro.family_tree = menu_1.menu_1(ro.family_tree);
                System.out.println(ro.family_tree);
            }
            if (str.equals("2")){
                consoleUI.add_human();
            }
            if (str.equals("3")){
                ro.family_tree = menu_3.menu_3(ro.family_tree);
                System.out.println("Test 3 " + ro.family_tree);
            }
            if (str.equals("7")){
                if (ts.clearFamilyTree()) {
                    ro.family_tree.clearHumanList();
                }
            }
            if (str.equals("8")){
                System.out.println("Загрузка данных из файла. Текущий список будет удален.");
                ro.setFamily_tree((FamilyTree) file_using.load(Config.filePath));
                System.out.println("Загружено семейное древо:");
                System.out.println(ro.family_tree);
            }
            if (str.equals("9")){
                System.out.println("Сохранение в файл.");
                System.out.println("Загружаю " + ro.family_tree);
                if (file_using.save(ro.family_tree, Config.filePath)){
                    System.out.println("Семейное древо успешно сохранено в файл.");
                } else {
                    System.out.println("Что-то пошло не так.");
                }
            }
        }
    }

}
