package ru.gb.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

//    public FamilyTree(List<Human> humanList) {
//        this.humanList = humanList;
//    }
//    public FamilyTree() {
//        this(new ArrayList<>());
//    }
    public FamilyTree() {
        humanList = new ArrayList<>();
    }
    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);
        }
    }
    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }
    public  Human getByPerson(String person) {
        for (Human human: humanList){
            if (human.getPerson().equals(person)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Human human : humanList) {
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}


