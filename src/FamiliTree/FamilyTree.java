package FamiliTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Human.Human;
import Human.HumanComparatorById;
import Human.HumanComparatorByName;
import Human.HumanConparatorByAge;

public class FamilyTree implements Iterable<Human>, Serializable {

    // #region Filds

    private List<Human> humanList;
    private int humansId;

    // #endregion

    // #region Constructor

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    // #endregion

    // #region Get

    public Human getById(int id) {
        for (Human human : humanList) {
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
        for (Human human : humanList) {
            info.append(human);
            info.append("\n");
        }
        return info.toString();
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
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

    public boolean add(Human human) {
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

    private void addToCildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(Human human) {

        for (Human parent : human.getParents()) {
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
        Collections.sort(humanList, new HumanConparatorByAge());
    }

    public void sortById() {
        humanList.sort(new HumanComparatorById());
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
    // #endregion

    // #region Overrid

    @Override
    public Iterator<Human> iterator() {
        return (Iterator<Human>) new FamiliTreeIterator(humanList);

    }

    @Override
    public String toString() {
        return getInfo();
    }

    // #endregion

}
