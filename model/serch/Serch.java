package model.serch;

import human.Human;
import model.tree.Check;
import model.tree.FamilyTree;


public class Serch {

    private FamilyTree<Human> humanList;

    public Serch(FamilyTree<Human> humanList) {
        this.humanList = humanList;
    }

    public String getInformationName(String all, FamilyTree<Human> humanList) {
        StringBuilder sb = new StringBuilder();
        Check check = new Check(humanList);
        if (check.checkname(humanList, all)) {
            for (Human human : humanList) {
                if (human.getName().equalsIgnoreCase(all)) {
                    sb.append(human.getInfo());
                    sb.append("\n");
                }
            }

        } else {
            System.out.println("Такого человека нет");
        }
        return sb.toString();

    }
}
