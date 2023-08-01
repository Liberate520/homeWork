package ru.gb.service;

import ru.gb.family_tree.FamilyTree;
import ru.gb.human.Human;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service(FamilyTree<Human> familyTree) {
        this.familyTree = new FamilyTree<>();
    }

    public void addHuman (Human human) {
        familyTree.addHuman(human);
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
