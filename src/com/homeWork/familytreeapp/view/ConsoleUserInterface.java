package com.homeWork.familytreeapp.view;

import java.util.List;
import java.util.Scanner;

import com.homeWork.familytreeapp.model.Person;
import com.homeWork.familytreeapp.presenter.FamilyTreePresenter;

public class ConsoleUserInterface<T extends Person<T>> implements UserInterface<T> {
    private FamilyTreePresenter<T> presenter;
    private Scanner scanner;
    private T parentTemplate;

    public ConsoleUserInterface(T parentTemplate) {
        this.scanner = new Scanner(System.in);
        this.parentTemplate = parentTemplate;
    }

    @Override
    public void setPresenter(FamilyTreePresenter<T> presenter) {
        this.presenter = presenter;
    }

    @Override
    public void run() {
        int choice;
        while (true) {
            System.out.println("\nВыбрать команду:");
            System.out.println("1. Добавить родителя и ребенка");
            System.out.println("2. Добавить брата или сестру");
            System.out.println("3. Получить детей родителя");
            System.out.println("4. Выход");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addParent();
                    break;
                case 2:
                    addSibling();
                    break;
                case 3:
                    getChildren();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Недопустимый выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    private void addParent() {
        System.out.print("Введите имя, возраст и пол родителя (через пробел): ");
        String[] parentInfo = scanner.nextLine().trim().split(" ");
        T parent = parentTemplate.createNewInstance(parentInfo[0], Integer.parseInt(parentInfo[1]), parentInfo[2]);

        System.out.print("Введите имя, возраст и пол ребенка (через пробел): ");
        String[] childInfo = scanner.nextLine().trim().split(" ");
        T child = parentTemplate.createNewInstance(childInfo[0], Integer.parseInt(childInfo[1]), childInfo[2]);

        presenter.addParent(parent, child);
        System.out.println("Родитель успешно добавлен.");
    }

    private void addSibling() {
        System.out.print("Введите имя родителя, возраст и пол (через пробел): ");
        String[] parentInfo = scanner.nextLine().trim().split(" ");
        T parent = parentTemplate.createNewInstance(parentInfo[0], Integer.parseInt(parentInfo[1]), parentInfo[2]);

        System.out.print("Введите имя, возраст и пол первого брата или сестры (через пробел): ");
        String[] sibling1Info = scanner.nextLine().trim().split(" ");
        T sibling1 = parentTemplate.createNewInstance(sibling1Info[0], Integer.parseInt(sibling1Info[1]), sibling1Info[2]);
        sibling1.setParent(parent);

        System.out.print("Введите имя, возраст и пол второго брата или сестры (через пробел): ");
        String[] sibling2Info = scanner.nextLine().trim().split(" ");
        T sibling2 = parentTemplate.createNewInstance(sibling2Info[0], Integer.parseInt(sibling2Info[1]), sibling2Info[2]);
        sibling2.setParent(parent);

        presenter.addParent(parent, sibling1);
        presenter.addParent(parent, sibling2);
        System.out.println("Брат и сестра успешно добавлены.");
    }
    
    private void getChildren() {
        System.out.print("Введите имя, возраст и пол родителя (через пробел): ");
        String[] parentInfo = scanner.nextLine().trim().split(" ");
        T parent = parentTemplate.createNewInstance(parentInfo[0], Integer.parseInt(parentInfo[1]), parentInfo[2]);
    
        List<T> children = presenter.getChildren(parent);
        if (children != null) {
            System.out.println("Дети:");
            for (T child : children) {
                System.out.println(child.toString());
            }
        } else {
            System.out.println("Для этого родителя не найдено детей.");
        }
    }
}
