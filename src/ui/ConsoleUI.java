package ui;

import service.Service;

import java.util.Scanner;

public class ConsoleUI {
    private int numberMenu;
    private boolean start;

    public ConsoleUI(){
        this.numberMenu = 0;
        this.start = true;
        menu();
    }

    private void menu(){
        while (start)
            switch (numberMenu){
                case 0:
                    mainMenu();
                    break;
                case 1:
                    addFamilyTree();
                    break;
                case 2:
                    readFamilyTree();
                    break;
                case 3:
                    start=false;
                    this.numberMenu = 0;
                    break;
            }
    }
    private void mainMenu(){
        Scanner scanner = new Scanner((System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("Введите номер действия:");
        sb.append("\n");
        sb.append("1. Создать семейное дерево и начать работу.");
        sb.append("\n");
        sb.append("2. Загрузить семейное дерево и продолжить работу.");
        sb.append("\n");
        sb.append("3. Выйти из прогрммы.");
        System.out.println(sb.toString());
        this.numberMenu = scanner.nextInt();
    }

    private void addFamilyTree(){
        System.out.println("Создание дерева");
        workWithFamilyTree();
        this.numberMenu = 0;
    }

    private void readFamilyTree(){
        System.out.println("Загрузка дерева");
        workWithFamilyTree();
        this.numberMenu = 0;
    }

    private void workWithFamilyTree(){
        System.out.println("Работа с деревом ");
        this.numberMenu = 0;
    }




}
