package familyTree.familyTree;

import familyTree.familyTree.iterator.HumanIterator;
import familyTree.human.Human;
import familyTree.human.comparators.HumanComparatorByAge;
import familyTree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyGroupItem<T>> implements Serializable, Iterable<T> {
    private int humanId;
    private List<T> humanList;

//    public FamilyTree() {
//        this(new ArrayList<>());
//    }

    public FamilyTree() {
        humanList = new ArrayList<>();
    }


    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }


    public int getId() {
        return humanId;
    }

    public void setId(int humanId) {
        this.humanId = humanId;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public T getById(int id) {
        if (!checkId(id)) {
            return null;
        }
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<T> getSiblings(int id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        T mother = human.getMother();
        T father = human.getFather();
        for (T child : mother.getChildren()) {
            if (!child.equals(human)) {
                res.add(child);
            }
        }
        for (T child : father.getChildren()) {
            if (!child.equals(human) && !res.contains(child)) {
                res.add(child);
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDevorce(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setDevorce(human1, human2);
        }
        return false;
    }

    public boolean setDevorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }


    public boolean remove(int humanId) {
        if (checkId(humanId)) {
            T person = getById(humanId);
            return humanList.remove(person);
        }
        return false;
    }

    private void addToParents(T human) {
        T mother = human.getMother();
        T father = human.getFather();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    // TODO: 10/1/2023 method wrote by myself
    private boolean checkId(int id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        for (T human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("In the tree ");
        sb.append(humanList.size());
        sb.append(" values: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }


}
