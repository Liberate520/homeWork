package family_tree.view;
import java.util.Scanner;

public class Menu_3{

    private Scanner scanner = new Scanner(System.in);

    public String get_choice(){
        printMenu();
        System.out.print("Введите соответствующую цифру меню: ");
        String str = scanner.nextLine();
        return str;
    }


    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Установить родителей;
                2 - Усыновить ребенка;
                3 - Зарегистрировать брак;
                                                
                """);
    }
}

