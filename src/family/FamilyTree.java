package family;

import humans.Human;
import service.HumanComparatorByAge;
import service.HumanComparatorByName;
import service.Writable;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (human != null) {
            if (!humanList.contains(human)) {
                humanList.add(human);
                if (human.getMother() != null) {
                    human.getMother().addChild(human);
                }
                if (human.getFather() != null) {
                    human.getFather().addChild(human);
                }
            }
        }
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getFullName().equals(name)) return human;
        }
        return null;
    }

    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append("В дереве: ");
        str.append(humanList.size());
        str.append(" объект(ов).\n");
        for (Human human : humanList) {
            str.append(human.getRelatives());
            str.append("\n");
        }
        return str.toString();
    }

    public void save(Writable writable, String path) throws IOException {
        writable.save(this, path);
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }
}
