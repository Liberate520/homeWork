import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner iScanner = new Scanner(System.in, "Cp866");
        System.out.println("Добро пожаловать в генеалогическое древо.\n");
        Boolean flag = true;

        while (flag) {
            System.out.println("1. Показать древо\n2. Добавить человека\n3. Поиск человека по имени\n4. Завершить.");
            System.out.print("Выберите действие : ");
            String choice = iScanner.next();

            if (choice.equals("1")) {
                System.out.println();
                System.out.println(tree.getTree());

            } else if (choice.equals("2")) {
                System.out.print("\nВведите имя : ");
                String name = iScanner.next();
                System.out.print("Введите пол : ");
                String sex = iScanner.next();
                System.out.print("Введите имя отца (если не известно 'нет') : ");
                String name_father = iScanner.next();
                System.out.print("Введите имя матери (если не известно 'нет') : ");
                String name_mother = iScanner.next();

                if (name_father.equalsIgnoreCase("нет") || name_mother.equalsIgnoreCase("нет")) {
                    tree.add(new Human(name, sex));
                } else tree.add(new Human(name, sex, name_father, name_mother));

                System.out.println(name + " Успешно добавлен в древо.\n");

            } else if (choice.equals("3")) {
                System.out.print("\nВведите имя : ");
                String name = iScanner.next();
                System.out.println(tree.getInfoHuman(name));
                System.out.println("\n1. Показать детей\n2. Показать мать\n3. Показать отца\n4. В основное меню");
                System.out.print("Выберите действие : ");
                choice = iScanner.next();
                
                if (choice.equals("1")) {
                    System.out.println();
                    System.out.println(tree.getInfoChildren(name));
                }
                else if (choice.equals("2")) System.out.println("\n" + tree.getInfoMother(name) + "\n");
                else if (choice.equals("3")) System.out.println("\n" + tree.getInfoFather(name) + "\n");
                
            } else flag = false;
        }
        iScanner.close();
    }
}