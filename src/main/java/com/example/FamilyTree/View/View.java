package com.example.FamilyTree.View;

import com.example.FamilyTree.DataForTree.Family;
import com.example.FamilyTree.DataForTree.FamilyTree;
import com.example.FamilyTree.DataForTree.Gender;
import com.example.FamilyTree.DataForTree.ObjectList.ObjectList;

import java.util.Scanner;

public class View {
    private Scanner scan= new Scanner(System.in);
    private ObjectList objectList = new ObjectList();
    private boolean work = true;

    public String MenuAction(FamilyTree familyTree) {
        System.out.println("\nВыберите и введите цифру, кому вывести семейное дерево, или показать родственную связь с другим человеком (цифры через пробел): ");
        System.out.println(familyTree.printObjectList());
        System.out.println("---------\n" +
               "  0: ВЫХОД");
        String answer = scan.nextLine();
        return answer;
    }

    public String ObjectSelection() {
        System.out.println("Выберите объект для семейного дерева: ");
        System.out.println(objectList);
        String objectSelection = "";
        while (work) {
            int choice = inputNumMenu(1, objectList.getObjectList().size());
            if (choice == -1) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            objectSelection = receiveClass(choice);
        }
        return objectSelection;
    }

    public FamilyTree<Family> addFamilyTree(String objectSelection, FamilyTree<Family> familyTree){
        work = true;
        while (work) {
            System.out.println("Добавить обьект " + objectSelection + " в семейное дерево? 1-Да / 0-Нет: ");
            if (bool()) {
                Family family = fillFamily(objectSelection);
                System.out.println("Ввести мать объекта?  1-Да / 0-Нет: ");
                if (bool()) {
                    family.addParents(fillFamily(objectSelection));
                }
                System.out.println("Ввести отца объекта?  1-Да / 0-Нет: ");
                if (bool()) {
                    family.addParents(fillFamily(objectSelection));
                }
                work = true;
                while (work) {
                    System.out.println("Ввести детей объекта?  1-Да / 0-Нет: ");
                    if (bool()) {
                        family.addChildren(fillFamily(objectSelection));
                    } else {
                        work = false;
                    }
                }
                work = true;
                familyTree.addObjectFamilyList(family);
            } else {
                work = false;
            }
        }
        return familyTree;
    }
    private int inputNumMenu(int from, int to) {
        String line = scan.nextLine();
        if (!checkLine(line, from, to)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line, int from, int to) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice >= from && choice <= to;
    }

    private String receiveClass(int choice){
        work = false;
        return objectList.getObjectList().get(choice-1);
    }

    private Family fillFamily(String objectSelection) {
        System.out.println("имя: ");
        String name = scan.nextLine();
        String birthday = getBirthday();
        Gender gender = getGender();
        Family element = objectList.createFamily(objectSelection, name, birthday, gender);
        return element;
    }

    private String getBirthday() {
        String birthday = "";
        work = true;
        while (work) {
            System.out.println("дата рождения формата гггг-мм-дд: ");
            birthday = scan.nextLine();
            if (!birthday.matches("[1-2][0-9][0-9][0-9][-](0[0-9]|1[0-2])[-](0[0-9]|1[0-9]|2[0-9]|3[0-1])")) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            work = false;
        }
        return birthday;
    }

    private Gender getGender() {
        Gender gender = Gender.male;
        work = true;
        while (work) {
            System.out.println("пол: \n"+printGender());
            int choice = inputNumMenu(1, Gender.values().length);
            if (choice == -1) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            gender = receiveGender(choice);
        }
        return gender;
    }

    private String printGender() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (Gender gender : Gender.values()) {
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(gender.getTitle());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private Gender receiveGender(int choice){
        work = false;
        return Gender.values()[choice-1];
    }

    public boolean bool() {
        int choice = 1;
        work = true;
        while (work) {
            choice = inputNumMenu(0,1);
            if (choice == -1) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            work = false;
        }
        return choice != 0;
    }
}