package ru.gb.java;

import java.util.List;
import java.util.Scanner;

public class SubMenu2 {
    public int subMenu(List<Person> personList) {

        System.out.println("\n Выберете персону: ");
        int count = 0;
        for (Person person : personList) {
        System.out.print(String.valueOf(++count)+ ". " + person + "\n");
        }

        System.out.print("\nВыберете пункт: ");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt()-1;
    }
}
