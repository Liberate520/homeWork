import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Set<People> boys = new HashSet<>();
        boys = People.getData();
        int choice = 0;
        Scanner in = new Scanner(System.in);
        String choiceFamil = "";

        while(true) {
            System.out.printf("""
                    Гинеалогическое дерево 3000!\n\n
                    1. Ввывести все;
                    2. Вывести определённую фамилию;
                    3. Определить дерево;
                    4. Выход.
                    Введите операцию: 
                    """);
            choice = in.nextInt();
            if (choice == 4) return;

            switch(choice) {
                case 1:
                    for (People i : boys) System.out.println(People.getFio(i));
                    break;

                case 2:
                    System.out.print("Введите фимилию: ");
                    choiceFamil = in.next();

                    for (People i : boys) {
                        // if ()
                    }

                    System.out.printf("\n\n");
                    break;

                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }
}