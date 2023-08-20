package genealogy_tree.model.Tree;

import genealogy_tree.model.Human.comparator.HumanComparatorByAge;
import genealogy_tree.model.Human.comparator.HumanComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GeneologiTree<E extends GeneologiTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;
    private int humansId;

    public GeneologiTree() {
        humanList = new ArrayList<>();
    }

    public GeneologiTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public boolean addHuman(E human) {
        if (humanList == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            return true;
        }
        if (humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            return true;
        }
        return false;
    }

    public void addToChildren(E human) {
        for (E children : human.getChildren())
            children.addChild(human);
    }

    public void addToParents(E human) {
        for (E parents : human.getParents())
            parents.addParents(human);
    }

    public void addParentsHuman(int id, int ids) {
        checkId(id);
        getById(id);
        E human = getById(id);
        checkId(ids);
        getById(ids);
        E human1 = getById(ids);
        addToParents(human1);
        human.addParents(human1);
    }
    public void addChildren(int id, int ids){
        checkId(id);
        getById(id);
        E human = getById(id);
        checkId(ids);
        getById(ids);
        E human1 = getById(ids);
        addToChildren(human1);
        human.addChild(human1);
    }

    public void getSiblingsHuman(int id){
        checkId(id);
        getById(id);
        getSiblings(id);
        List<E> result = getSiblings(id);
        System.out.println(result);
    }

    public void setDivorceHuman(int id, int ids){
        checkId(id);
        getById(id);
        E human = getById(id);
        checkId(ids);
        getById(ids);
        E human1 = getById(ids);
        setDivorce(human, human1);
    }

    public void addSpouseHuman(int id, int ids){
        checkId(id);
        getById(id);
        E human = getById(id);
        checkId(ids);
        getById(ids);
        E human3 =  getById(ids);
        setWedding(human, human3);
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> result = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<E> getByName(String name) {
        List<E> result = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                result.add(human);
            }
        }
        return result;
    }


    public boolean setWedding(E human1, E human2) {

        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }

    }


    public boolean setDivorce(E human1, E human2) {

        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int humansId) {
        if (checkId(humansId)) {
            E e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }

    public boolean checkId(int id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (E human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List Human:\n");
        for (E human : humanList) {
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
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }


}