package ru.gb.family_tree.tree;

import ru.gb.family_tree.humans.Human;
import ru.gb.family_tree.humans.HumanComparatorByDate;
import ru.gb.family_tree.humans.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean addHumans(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChild(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChild(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human human = getByID(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    private Human getByID(long id) {
        if (checkId(id)) {
            for (Human human: humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In the tree: ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" objects: \n");
        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByDate() {
        humanList.sort(new HumanComparatorByDate());
    }
}
