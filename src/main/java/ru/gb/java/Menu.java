package ru.gb.java;

import java.io.Serializable;
import java.util.*;

public class Menu {
    public int MenuOut() {
        boolean flag = true;
        while (flag) {
            System.out.println("Генеалогическое древо");
            System.out.println("Меню:");

            System.out.println("1. Добавить человека");
            System.out.println("2. Добавить нескольких человек");
            System.out.println("3. Установить родство");
            System.out.println("4. Просмотр родства");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Восстановить из файла");
            System.out.println("7. Выход");
            System.out.print("\n Выберете пункт меню: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 5) {
                flag = false;
            }
            return choice;
        }
        return 0;
    }
}