package ru.gb.model.service;

import ru.gb.model.family_tree.FamilyTree;
import ru.gb.model.human.Human;
import ru.gb.model.human.HumanComparatorByAge;
import ru.gb.model.human.HumanComparatorByName;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }
    public void setConnection(Human child, Human parent) {
        familyTree.setConnection(child, parent);
    }
    public void addHuman (Human human) {
        familyTree.addHuman(human);
    }
    public void SortByName(){
        familyTree.SortByName();
    }
    public void SortByAge(){
        familyTree.SortByAge();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(familyTree.getHumansId());
        sb.append(" объектов: \n");

        for (Human human: familyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
