package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private final ArrayList<Human> children;
    {
        children = new ArrayList<>();
    }
    private final ArrayList<Human> brothersAndSisters;
    {
        brothersAndSisters = new ArrayList<>();
    }


    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Human(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public Human(String name){
        this.name = name;
    }

    public Human(){
    }
    //---------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public ArrayList<Human> getBrothersAndSisters() {
        return brothersAndSisters;
    }

    public void setBrothersAndSisters(Human children) {
        this.brothersAndSisters.add(children);
    }
    //----------------------------------------------------------------------------------
    public static void printNamesHuman(Tree tree) {  // Печать имен Human
        for (int i = 0; i < tree.getBigFamily().size(); i++) {
            System.out.printf("%d - %s%n", i + 1, tree.getBigFamily().get(i).getName());
        }
    }
    public static void printHuman(Tree tree, int indexH) {  // Печать Human
        System.out.printf("%s, %s, %s, %s%n", tree.getBigFamily().get(indexH).getName(), tree.getBigFamily().get(indexH).getGender(),
                tree.getBigFamily().get(indexH).getDateOfBirth(), tree.getBigFamily().get(indexH).getDateOfDeath());
        System.out.println();
    }

    public static LocalDate creatingADate(String sDate){  // создание даты из строки
        ArrayList<String> dateL = new ArrayList<>(Arrays.asList(sDate.split(" ")));
        LocalDate date = LocalDate.of(Integer.parseInt(dateL.get(2)),
                Integer.parseInt(dateL.get(1)), Integer.parseInt(dateL.get(0)));
        return date;
    }

    public static void superPrintHumanHC(Tree tree, int indexH) {  // Печать Human центральной фигуры
        System.out.print(String.format("Ф.И.О.: %s, Пол: %s, Дата рождения: %s",
                tree.getBigFamily().get(indexH).getName(),
                tree.getBigFamily().get(indexH).getGender(),
                tree.getBigFamily().get(indexH).getDateOfBirth()));

        if (tree.getBigFamily().get(indexH).getDateOfDeath() == null) {
            System.out.print("");
        } else {
            System.out.println(String.format(" Дата смерти: %s", tree.getBigFamily().get(indexH).getDateOfDeath()));
        }
        System.out.println();
        System.out.println(String.format("Мама: %s", tree.getBigFamily().get(indexH).mother));
        System.out.println(String.format("Папа: %s", tree.getBigFamily().get(indexH).father));
        if (tree.getBigFamily().get(indexH).children != null){
            for (int i = 0; i < tree.getBigFamily().get(indexH).children.size(); i++) {
                System.out.println(String.format("Сын/Дочь: %s", tree.getBigFamily().get(indexH).children.get(i).getName()));
            }
        }
        if (tree.getBigFamily().get(indexH).brothersAndSisters != null){
            for (int i = 0; i < tree.getBigFamily().get(indexH).brothersAndSisters.size(); i++) {
                System.out.println(String.format("Брат/Сестра: %s", tree.getBigFamily().get(indexH).brothersAndSisters.get(i).getName()));
            }
        System.out.println("\n\n");
        }
    }
}
