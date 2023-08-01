package FamiliTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Human.HumanComparatorByBirthDate;
import Human.HumanComparatorById;
import Human.HumanComparatorByName;
import Human.HumanConparatorByAge;
import Servis.HumanItem;

public class FamilyTree<E extends HumanItem<E>> implements Iterable<E>, Serializable {

    // #region Fields

    private List<E> humanList;
    private int humansId;

    // #endregion

    // #region Constructor

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    // #endregion

    // #region Get

    public E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("В дереве ");
        info.append(humanList.size());
        info.append(" объектов; \n");
        for (E human : humanList) {
            info.append(human);
            info.append("\n");
        }
        return info.toString();
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    // #endregion

    // #region Set

    // #endregion

    // #region Metods

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToCildren(human);

            return true;
        }
        return false;
    }

    private void addToCildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(E human) {

        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    // private boolean checkId(int id){
    // if (id>=humansId || id<0){
    // return false;
    // }
    // for (Human human: humanList){
    // if (human.getId()==id){
    // return true;
    // }

    // }
    // return false;
    // }

    public void sortByAge() {
        Collections.sort(humanList, new HumanConparatorByAge<>());
    }

    public void sortById() {
        humanList.sort(new HumanComparatorById<>());
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthData() {
        humanList.sort(new HumanComparatorByBirthDate<>());
    }
    // #endregion

    // #region Overrid

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new FamiliTreeIterator<>(humanList);

    }

    @Override
    public String toString() {
        return getInfo();
    }

    // #endregion

}
