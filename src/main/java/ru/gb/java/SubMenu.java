package ru.gb.java;

import java.util.Scanner;

public class SubMenu {
    public int subMenu() {

        System.out.println("\n Варианты добавления:");

        System.out.println("1. Добавить к персоне родителя и ребёнка");
        System.out.println("2. Добавить к персоне родителя");
        System.out.println("3. Добавить к персоне ребёнка");

        System.out.print("\nВыберете пункт: ");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
