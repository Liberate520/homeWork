package family_tree.view;


import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    Menu_3 menu_3;
    Menu_1 menu_1;
    ConsoleUI consoleUI;

    public Menu() {
        scanner = new Scanner(System.in);
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
            str = scanner.nextLine();
            if (str.equals("1")){
                 String sort_by = menu_1.get_choice();
                 consoleUI.getFamilyTreeInfo(sort_by);
            }
            if (str.equals("2")){
                consoleUI.add_human();
            }
            if (str.equals("3")){
                consoleUI.set_relatives(menu_3.get_choice());
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
