package ru.gb.family_tree.service;

import ru.gb.family_tree.familytree.FamilyTree;
import ru.gb.family_tree.human.Human;

import java.util.List;


public class Service {
    private long id;

    private static List<Human> humanList;

    public List<Human> getHumanList() {
        return humanList;
    }
    public Service() {
        FamilyTree familyTree;
    }
    public static String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
/*
    public void sortByName(){
        familyTree.sortByName(familyTree);
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }*/
}
