package familyTree;

import familyTree.Human.Human;
import familyTree.Human.Iterator.HumanIterator;
import familyTree.Human.Comporator.humanComporatorByAge;
import familyTree.Human.Comporator.humanComporatorBySurname;
import familyTree.Human.Comporator.humanComporatosByName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int idHuman;
    private List<Human> humanList;



    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
            human.setId(idHuman++);
            return true;
        }
        return false;
    }
    public void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getByName(String name) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" человека: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }


//    @Override
//    public String toString() {
//        return "FamilyTree{" + "idHuman=" + idHuman + ", humanList=" + humanList + '}';
//    }

    @Override
      public Iterator<Human> iterator () {
//        return (Iterator<Human>) new HumanIterator(humanList);
        return (Iterator<Human>) new HumanIterator(humanList);
    }

    public void sortByName() {
        Collections.sort(humanList, new humanComporatosByName());
    }

    public void sortBySurname() {
        Collections.sort(humanList, new humanComporatorBySurname());
    }

    public void sortByAge() {
        Collections.sort(humanList, new humanComporatorByAge());
    }
}
