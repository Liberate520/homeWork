package model.tree;

import human.Human;

public class SerchPerson {

    private FamilyTree<Human> humanList;

    public SerchPerson(FamilyTree<Human> humanList) {
        this.humanList = humanList;
    }

    public String getInformation(String all, FamilyTree<Human> humanList) {
        StringBuilder sb = new StringBuilder();
        CheckName checkName = new CheckName(humanList);
        if (checkName.checkName(humanList, all)) {
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
