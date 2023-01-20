package tree;

import java.util.Scanner;

public class UserMenu {

    public UserMenu() {
    }

    public void startMenu() throws InterruptedException {

        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            Thread.sleep(1000);
            System.out.print("\n*** Меню ***\n0. Выйти\n1. Создать дерево\n2. Создать кота\n" +
                    "3. Создать человека\n4. Распечатать дерево\n******\n\nВведите номер действия из списка: ");
            String choice = in.nextLine();
            switch (choice){
                case "0":
                    System.out.println("\nСпасибо, что воспользовались нашим сервисом. Ждем Вас снова.");
                    exit = true;
                    break;
                case "1":
                    System.out.print("Введите имя для дерева: ");
                    String name = in.nextLine();
                    FamilyTree hTree = new FamilyTree<>(name);
                    break;
                case "2":
                    System.out.print("Введите имя: ");
                    name = in.nextLine();
                    System.out.print("Введите пол (M / F): ");
                    String gender = in.nextLine();
                    System.out.print("Введите возраст: ");
                    Integer age = Integer.parseInt(in.nextLine());
                    Gender hgen = gender == "M" ? Gender.Male : Gender.Female;
                    Human newHuman = new Human(name, hgen, age);
                    break;
                case "3":
                    System.out.print("Введите имя: ");
                    name = in.nextLine();
                    System.out.print("Введите пол (M / F): ");
                    gender = in.nextLine();
                    System.out.print("Введите возраст: ");
                    age = Integer.parseInt(in.nextLine());
                    Gender cgen = gender == "M" ? Gender.Male : Gender.Female;
                    Cat newCat = new Cat(name, cgen, age);
                    break;
                case "4":

                    break;
            }
        }
    }

}
