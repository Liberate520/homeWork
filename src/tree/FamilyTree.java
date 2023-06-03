package tree;

import human.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<F extends FamilyTreeItem> implements Serializable, Iterable<F> {
    private List<F> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<F> humanList) {
        this.humanList = humanList;
    }


    public boolean add(F human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if ((human.getMother() != null)) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public List<F> getHumans() {
        return humanList;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (F human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<F> getParents(F human) {
        List<F> parents = new ArrayList<>();
        F mother = (F) human.getMother();
        if (mother != null) {
            parents.add(mother);
        }
        F father = (F) human.getFather();
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    public List<F> getSiblings(F human) {
        List<F> siblings = new ArrayList<>();
        List<F> parents = getParents(human);
        for (F parent : parents) {
            List<F> parentSiblings = getChildren(parent);
            parentSiblings.remove(human);
            siblings.addAll(parentSiblings);
        }
        return siblings;
    }

    public List<F> getChildren(F human) {
        return (List<F>) human.getChildren();
    }

    @Override
    public Iterator<F> iterator() {
        return new HumanIterator(humanList);
    }
}
