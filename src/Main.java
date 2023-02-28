import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        ReadWritable fileHandler = new FileHandler("data.out");

        tree.add(new Person("Михаил Федорович", Gender.MALE, 1613, null, null));
        tree.add(new Person("Евдокия Лукьяновна Стрешнева", Gender.FEMALE, 1608, null, null));
        tree.add(new Person("Алексей Михайлович", Gender.MALE, 1645, tree.getByName("Михаил Федорович"), tree.getByName("Евдокия Лукьяновна Стрешнева")));


        while (true) {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Поиск(1), Весь список(2), Сортировка по имени(3), Сортировка по дате рождения(4), Сохранить(5), Востановить(6), Выход(7): ");
            int choice = iScanner.nextInt();
            if (choice == 1) {
                Scanner Scanner = new Scanner(System.in);
                System.out.println("Введите полное имя нужного человека: ");
                String search = Scanner.nextLine();
                Person rightPerson = tree.getByName(search);
                System.out.println(rightPerson.getInfo());

            }else if (choice == 2) {
                System.out.println(tree.getInfo());
            }else if (choice == 3) {
                tree.sortByName();
                System.out.println(tree.getInfo());
            }else if (choice == 4) {
                tree.sortByBirthDate();
                System.out.println(tree.getInfo());
            }else if (choice == 5) {
                fileHandler.write(tree);
            }else if (choice == 6) {
                fileHandler.read();
            }else if (choice == 7) {
                return;
            }
        }



    }
}
