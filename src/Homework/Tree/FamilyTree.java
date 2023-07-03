package Homework.Tree;

import Homework.Human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        familyList.add(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья:\n");
        for (Human human : familyList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void getHuman(String name) {
        for (Human human : familyList) {
            if (human.getName().equals(name)) {
                System.out.println(human);
            }
        }
    }

    //TODO добавить метод поиска братьев

    //TODO добавить метод поиска родителей

    //TODO добавить метод поиска бабушек/дедушек

    //TODO добавить метод добавления родителей и детей

    //TODO метод getByName - поиска по имени

    public void getChild(String name) {
        List<String> children = new ArrayList<>();
        for (Human human : familyList) {
            if (human.getFather() != null && human.getMother() != null) {
                if (human.getFather().getName().equals(name) || human.getMother().getName().equals(name)) {
                    children.add(human.getName());
                }
            }
            if (human.getFather() != null && human.getMother() == null) {
                if (human.getFather().getName().equals(name)) {
                    children.add(human.getName());
                }
            }
            if (human.getFather() == null && human.getMother() != null) {
                if (human.getMother().getName().equals(name)) {
                    children.add(human.getName());
                }
            }
        }

        if (children.isEmpty()) {
            System.out.println("Извините! Данных о детях " + name + " нет!");
        } else {
            System.out.println("Дети " + name + ":");
            for (String child : children) {
                System.out.println("- " + child);
            }
        }
    }
}