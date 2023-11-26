package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<Human>();

    public boolean setSpouse(Human firstSpouce, Human secondSpouce) {
        if (firstSpouce.getSpouse() == null && secondSpouce.getSpouse() == null) {
            firstSpouce.setSpouse(secondSpouce);
            secondSpouce.setSpouse(firstSpouce);
        } else {
            System.out.println(firstSpouce.getName() + " или " + secondSpouce.getName() + " уже имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
        }
        if (!this.familyTree.contains(firstSpouce)) {
            familyTree.add(firstSpouce);
        }
        if (!this.familyTree.contains(secondSpouce)) {
            familyTree.add(secondSpouce);
        }
        System.out.println("Вы указали, что: " + firstSpouce.getName() + " и " + secondSpouce.getName() + " женаты");
        return true;
    }

    public boolean divorce(Human firstSpouce, Human secondSpouce) {
        if (firstSpouce.equals(secondSpouce.getSpouse())) {
            firstSpouce.setSpouse(null);
            secondSpouce.setSpouse(null);
            System.out.println(firstSpouce.getName() + " и " + secondSpouce.getName() + "более не женаты");
        } else {
            System.out.println(firstSpouce.getName() + " или " + secondSpouce.getName() + "не имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
        }
        return true;


    }

    public boolean setMother(Human children, Human mother) {
        children.setMother(mother);
        if (!familyTree.contains(children)) {
            familyTree.add(children);
        }
        if (!familyTree.contains(mother)) {
            familyTree.add(mother);
        }
        if (mother.getChildren() != null && mother.getChildren().contains(children)) {
            System.out.println("Такой ребенок уже задан");
            return true;
        } else {
            mother.setChildren(children);
            System.out.println("Вы указали, что: " + mother.getName() + " мать " + children.getName());
        }
        return true;
    }

    public boolean setFather(Human children, Human father) {
        children.setFather(father);
        if (!familyTree.contains(children)) {
            familyTree.add(children);
        }
        if (!familyTree.contains(father)) {
            familyTree.add(father);
        }
        if ( father.getChildren() != null && father.getChildren().contains(children)) {
            System.out.println("Такой ребенок уже задан");
            return true;
        } else {
            father.setChildren(children);
            System.out.println("Вы указали, что: " + father.getName() + " отец " + children.getName());
        }
        return true;
    }

    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Семейное древо данной семьи: \n");
        for (Human human : familyTree) {
            sb.append(human.getName()).append("\n");
        }
        return sb.toString();
    }

    //TODO: Дописать метод, который рекурсивно собирает дерево семьи
}
