package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HumanConnections {
    private Human theCentralFigure;
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private ArrayList<Human> brothersAndSisters;

    public HumanConnections(Human theCentralFigure) {
        this.theCentralFigure = theCentralFigure;
    }

    //---------------------------------------------------------------------------------------------------------------
    public Human getTheCentralFigure() {
        return theCentralFigure;
    }

    public void setTheCentralFigure(Human theCentralFigure) {
        this.theCentralFigure = theCentralFigure;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(ArrayList<Human> dbH, ArrayList<HumanConnections> dbHC, int IndCentralFigure,
                          Scanner scanner) {
        System.out.println("Выберете предпологаемую mother из списка");
        ArrayList<Human> temporary = new ArrayList<>();
        for (int i = 0; i < dbH.size(); i++) {
            if ((dbH.get(i).getGender() == Gender.female || dbH.get(i).getGender() == null) && dbH.get(i).getName()
                    != dbHC.get(IndCentralFigure).theCentralFigure.getName()) {
                temporary.add(dbH.get(i));
            }
        }
        for (int i = 0; i < temporary.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, temporary.get(i).getName()));
        }
        this.mother = temporary.get(Integer.parseInt(scanner.nextLine()) - 1);

    }

    public Human getFather() {
        return father;
    }

    public void setFather(ArrayList<Human> dbH, ArrayList<HumanConnections> dbHC, int IndCentralFigure, Scanner scanner) {
        System.out.println("Выберете предпологаемого father из списка");
        ArrayList<Human> temporary = new ArrayList<>();
        for (int i = 0; i < dbH.size(); i++) {
            if ((dbH.get(i).getGender() == Gender.male || dbH.get(i).getGender() == null) && dbH.get(i).getName()
                    != dbHC.get(IndCentralFigure).theCentralFigure.getName()) {
                temporary.add(dbH.get(i));
            }
        }
        for (int i = 0; i < temporary.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, temporary.get(i).getName()));
        }
        this.father = temporary.get(Integer.parseInt(scanner.nextLine()) - 1);

    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> dbH, ArrayList<HumanConnections> dbHC, int IndCentralFigure, Scanner scanner) {
        System.out.println("Выберете предпологаемого children из списка");
        ArrayList<Human> temporary = new ArrayList<>();
        for (int i = 0; i < dbH.size(); i++) {
            if (dbH.get(i).getName() != dbHC.get(IndCentralFigure).theCentralFigure.getName()) {
                temporary.add(dbH.get(i));
            }
        }
        for (int i = 0; i < temporary.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, temporary.get(i).getName()));
        }
        ArrayList<Human> ch = new ArrayList<>(Arrays.asList(temporary.get(Integer.parseInt(scanner.nextLine()) - 1)));
        if (dbHC.get(IndCentralFigure).children != null){
        for (int i = 0; i < dbHC.get(IndCentralFigure).children.size(); i++) {
            ch.add(dbHC.get(IndCentralFigure).children.get(i));
        }
        }

        this.children = ch;

    }

    public ArrayList<Human> getBrothersAndSisters() {
        return brothersAndSisters;
    }

    public void setBrothersAndSisters(ArrayList<Human> dbH, ArrayList<HumanConnections> dbHC, int IndCentralFigure, Scanner scanner) {
        System.out.println("Выберете предпологаемого BrotherOrSister из списка");
        ArrayList<Human> temporary = new ArrayList<>();
        for (int i = 0; i < dbH.size(); i++) {
            if (dbH.get(i).getName() != dbHC.get(IndCentralFigure).theCentralFigure.getName()) {
                temporary.add(dbH.get(i));
            }
        }
        for (int i = 0; i < temporary.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, temporary.get(i).getName()));
        }
        ArrayList<Human> ch = new ArrayList<>(Arrays.asList(temporary.get(Integer.parseInt(scanner.nextLine()) - 1)));
        if (dbHC.get(IndCentralFigure).brothersAndSisters != null){
            for (int i = 0; i < dbHC.get(IndCentralFigure).brothersAndSisters.size(); i++) {
                ch.add(dbHC.get(IndCentralFigure).brothersAndSisters.get(i));
            }
        }
        this.children = ch;
    }
    //--------------------------------------------------------------------------------------------------------------
    public static void printNameHumanConnect(ArrayList<HumanConnections> list) {  // Печать центральных фигур
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("%d - %s", i + 1, list.get(i).theCentralFigure.getName()));
        }
    }

    public static void printHumanHC(ArrayList<HumanConnections> list, int indexH) {  // Печать Human центральной фигуры
        System.out.println("Центральная фигура");
        System.out.println(String.format("%s, %s, %s, %s",
                list.get(indexH).theCentralFigure.getName(),
                list.get(indexH).theCentralFigure.getGender(),
                list.get(indexH).theCentralFigure.getDateOfBirth(),
                list.get(indexH).theCentralFigure.getDateOfDeath()));

        System.out.println();
    }

    public static void SuperPrintHumanHC(ArrayList<HumanConnections> list, int indexH) {  // Печать Human центральной фигуры
        System.out.println("Центральная фигура");
        System.out.print(String.format("Ф.И.О. -%s-, Пол-%s-, Дата рождения -%s-",
                list.get(indexH).theCentralFigure.getName(),
                list.get(indexH).theCentralFigure.getGender(),
                list.get(indexH).theCentralFigure.getDateOfBirth()));

        if (list.get(indexH).theCentralFigure.getDateOfDeath().equals("Да здравствует!")) {
            System.out.print("");
        } else {
            System.out.println(String.format(" Дата смерти -%s-", list.get(indexH).theCentralFigure.getDateOfDeath()));
        }
        System.out.println();
        System.out.println(String.format("Мама -%s-", list.get(indexH).mother));
        System.out.println(String.format("Папа -%s-", list.get(indexH).father));
        if (list.get(indexH).children != null){
        for (int i = 0; i < list.get(indexH).children.size(); i++) {
                System.out.println(String.format("Сын/Дочь -%s-", list.get(indexH).children.get(i).getName()));
        }
        }
        if (list.get(indexH).brothersAndSisters != null){
        for (int i = 0; i < list.get(indexH).brothersAndSisters.size(); i++) {
            System.out.println(String.format("Брат/Сестра -%s-", list.get(indexH).brothersAndSisters.get(i).getName()));
        }
        }

    }
}

