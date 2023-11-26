package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<Human>();

    public boolean setSpouse(Human firstHuman, Human secondHuman) {
        if (firstHuman.getSpouse() == null && secondHuman.getSpouse() == null) {
            firstHuman.setSpouse(secondHuman);
            secondHuman.setSpouse(firstHuman);
        } else {
            System.out.println(firstHuman.getName() + " или " + secondHuman.getName() + " уже имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
        }
        if (!this.familyTree.contains(firstHuman)) {
            familyTree.add(firstHuman);
        }
        if (!this.familyTree.contains(secondHuman)) {
            familyTree.add(secondHuman);
        }
        System.out.println("Вы указали, что: " + firstHuman.getName() + " и " + secondHuman.getName() + " женаты");
        return true;
    }

    public boolean divorce(Human firstHuman, Human secondHuman) {
        if (firstHuman.equals(secondHuman.getSpouse())) {
            firstHuman.setSpouse(null);
            secondHuman.setSpouse(null);
            System.out.println(firstHuman.getName() + " и " + secondHuman.getName() + "более не женаты");
        } else {
            System.out.println(firstHuman.getName() + " или " + secondHuman.getName() + "не имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
        }
        return true;


    }

    public boolean setMother(Human firstHuman, Human secondHuman) {
        firstHuman.setMother(secondHuman);
        secondHuman.setMother(firstHuman);
        familyTree.add(firstHuman);
        familyTree.add(secondHuman);
        System.out.println("Вы указали, что: " + firstHuman.getName() + " и " + secondHuman.getName() + " мать");
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
}
