import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        People book = new People();
        book.getData();

        int choice = 0;
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.printf("""
                    Гинеалогическое дерево 3000!\n\n
                    1. Ввывести все;
                    2. Вывести определённую фамилию;
                    3. Определить дерево;
                    4. Выход.\n
                    Введите операцию: 
                    """);
            choice = in.nextInt();
            if (choice == 4) {
                in.close();
                return;
            }

            switch(choice) {
                case 1:
                    book.printBook();
                    break;

                case 2:
                    book.getFamil();
                    break;

                case 3:
                    book.getTree();
                    break;

                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }
}