package Tree;

import Human.Human;

import java.io.Serializable;
import java.util.*;

public class Tree implements Serializable, Iterable<Human> {
    private List<Human> relatives;

    public Tree() {
        relatives = new ArrayList<>();
    }

    public List<Human> getRelatives() {
        return relatives;
    }

    public void add(Human human) {
        if (!relatives.contains(human)) {
            relatives.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getWifeOrHusband() != null) {
                human.getWifeOrHusband().setWifeOrHusband(human);
            }
        }
    }
    public void createFamily(Human father, Human mother, Human child) {
        child.setFather(father);
        child.setMother(mother);
        mother.setWifeOrHusband(father);
        if (!relatives.contains(mother)){
            relatives.add(mother);
        }
        if (!relatives.contains(father)){
        relatives.add(father);}
        if (!relatives.contains(child)){
        relatives.add(child);}
    }
    public Human getByName(String name) {
        String[] tempString = name.split(" ");
        for (Human human : relatives) {
            if (human.getSecondName() == tempString[0]
                    && human.getFirstName() == tempString[1]
                    && human.getPatronymic() == tempString[2]) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве: ");
        sb.append(relatives.size());
        sb.append(" объектов: \n");
        int count=1;
        for (Human human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getInfo());
            sb.append(" \n");
            count++;
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new humanIterator(relatives);
    }


}
