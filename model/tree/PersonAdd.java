package model.tree;

import human.Human;

public class PersonAdd {

    private FamilyTree<Human> humanList;

    public PersonAdd(FamilyTree<Human> humanList) {
        this.humanList = humanList;
    }

    public String toFamilyTree(String name, String father, String mother, String year, FamilyTree<Human> humanList) {
        CheckName checkName = new CheckName(humanList);
        if (checkName.checkName(humanList, name)) {
            System.out.println("Такой человек уже есть в базе");
        } else {

            if (father.equalsIgnoreCase(" нет")) {

                humanList.add(new Human(name, null, humanList.getByName(mother), year));
                System.out.println(humanList.getInfo());
            } else if (mother.equalsIgnoreCase(" нет")) {
                humanList.add(new Human(name, humanList.getByName(father), null, year));
                System.out.println(humanList.getInfo());
            } else if (father.equalsIgnoreCase(" нет") || mother.equalsIgnoreCase(" нет")) {
                humanList.add(new Human(name, year));
                System.out.println(humanList.getInfo());
            } else {
                humanList.add(new Human(name, humanList.getByName(father), humanList.getByName(mother), year));
                System.out.println(humanList.getInfo());
            }

        }
        return humanList.toString();
    }

}
