package familyTree.model.familyTree;

import familyTree.model.familyTree.comparators.HumanComparatorByAge;
import familyTree.model.familyTree.comparators.HumanComparatorByName;
import familyTree.model.familyTree.iterator.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyGroupItem<T>> implements Serializable, Iterable<T> {
    private int humanId;
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean addToFamily(T el) {
        if (el == null) {
            return false;
        }
        if (!humanList.contains(el)) {
            humanList.add(el);
            el.setId(humanId++);

            addToParents(el);
            addToChildren(el);
            return true;
        }
        return false;
    }

    public T getById(long id) {
        if (!checkId(id)) {
            return null;
        }
        for (T el : humanList) {
            if (el.getId() == id) {
                return el;
            }
        }
        return null;
    }

    public List<T> getSiblings(int id) {
        T el = getById(id);
        if (el == null) {
            return null;
        }
        List<T> res = new ArrayList<>();

        T mother = el.getMother();
        T father = el.getFather();
        for (T child : mother.getChildren()) {
            if (!child.equals(el)) {
                res.add(child);
            }
        }
        for (T child : father.getChildren()) {
            if (!child.equals(el) && !res.contains(child)) {
                res.add(child);
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T el : humanList) {
            if (el.getName().equals(name)) {
                res.add(el);
            }
        }
        return res;
    }


    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T el1 = getById(humanId1);
            T el2 = getById(humanId2);
            return setWedding(el1, el2);
        }
        return false;
    }

    public boolean setWedding(T el1, T el2) {
        if (el1.getSpouse() == null && el2.getSpouse() == null) {
            el1.setSpouse(el2);
            el2.setSpouse(el1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDevorce(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T el1 = getById(humanId1);
            T el2 = getById(humanId2);
            return setDevorce(el1, el2);
        }
        return false;
    }

    public boolean setDevorce(T el1, T el2) {
        if (el1.getSpouse() != null && el2.getSpouse() != null) {
            el1.setSpouse(null);
            el2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }


    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            T el = getById(humanId);
            return humanList.remove(el);
        }
        return false;
    }

    private void addToParents(T el) {
        T mother = el.getMother();
        T father = el.getFather();
        if (mother != null) {
            mother.addChild(el);
        }
        if (father != null) {
            father.addChild(el);
        }
    }

    private void addToChildren(T el) {
        for (T child : el.getChildren()) {
            child.addParent(el);
        }
    }

    private boolean checkId(long id) {
        return id < humanId && id >= 0;
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("In the tree ");
        sb.append(humanList.size());
        sb.append(" values: \n");
        for (T el : humanList) {
            sb.append(el);
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
        return new FamilyTreeIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }


}
