package familytree.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("=== Меню ===");
        System.out.println("1. Добавить человека, детей, родителей");
        System.out.println("2. Вывести список людей");
        System.out.println("3. Вывести сортированный по имени список");
        System.out.println("4. Вывести сортированный по фамилии список");
        System.out.println("0. Выход");
        System.out.println("Введите номер операции:");
    }

    public int getUserChoice() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void close() {
        scanner.close();
    }
}
