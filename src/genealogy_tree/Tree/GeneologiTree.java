package genealogy_tree.Tree;

import genealogy_tree.Human.Human;
import genealogy_tree.Human.comparators.HumanComparatorByAge;
import genealogy_tree.Human.comparators.HumanComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GeneologiTree implements Serializable, Iterable<Human> {

    private List<Human> humanList;
    private long humansId;

    public GeneologiTree() {
        humanList = new ArrayList<>();
    }

    public GeneologiTree(List<Human> humanList) {
        this.humanList = humanList;
    }


    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToChildren(Human human) {
        for (Human children : human.getChildren()) {
            children.addChild(human);
        }
    }

    private void addToParents(Human human) {
        for (Human parents : human.getParents()) {
            parents.addParents(human);
        }
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> result = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<Human> getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);

        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List Human:\n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumanInfo();
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

}
