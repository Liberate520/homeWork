package family_tree.human_family;

import java.util.ArrayList;
import java.util.List;

import family_tree.humans.Human;

public class FamilyTree implements IFamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public List<Human> getAllChildren(Human parent) {
        List<Human> children = new ArrayList<>();
        for (Human human : humans) {
            if (human.getParents().contains(parent)) {
                children.add(human);
            }
        }
        return children;
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    @Override
    public void removeHuman(Human human) {
        humans.remove(human);
    }

    @Override
    public void updateHuman(Human human) {
        int index = humans.indexOf(human);
        if (index != -1) {
            humans.set(index, human);
        }
    }

    @Override
    public List<Human> getAllHumans() {
        return humans;
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:");
        for (Human human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        ((FamilyTree) humans).sortByName();
    }

    public void sortByYear() {
        ((FamilyTree) humans).sortByYear();
    }
}
