package family_tree;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void createFamily(Human parent1, Human parent2, Human child) {
        child.createRelatings(parent1, parent2, child);
        humanList.add(parent1);
        humanList.add(parent2);
        humanList.add(child);
    }

    public void addChilrenForParentsName(FamilyTree familyTree){
        for (Human possibleChild : humanList) {
            for (Human possibleParent : humanList) {
                if ((possibleChild.getMother() != null) && (possibleChild.getMother().getName().equals(possibleParent.getName()))) {
                    possibleParent.addChildren(possibleChild);
                }
                if ((possibleChild.getMother() != null) && (possibleChild.getFather().getName().equals(possibleParent.getName()))) {
                    possibleParent.addChildren(possibleChild);
                }
            }
        }
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public Human getByName(String name){
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("---------\n");
        }
        return stringBuilder.toString();
    }

    public String toTxt() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            stringBuilder.append(human.toTxt());
        }
        return stringBuilder.toString();
    }
}
