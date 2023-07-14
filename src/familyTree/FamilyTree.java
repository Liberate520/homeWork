package familyTree;

import familyTree.Human.Iterator.HumanIterator;
import familyTree.Human.Comporator.humanComporatorByAge;
import familyTree.Human.Comporator.humanComporatorBySurname;
import familyTree.Human.Comporator.humanComporatorByName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private int idHuman;
    private List<E> humanList;



    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(idHuman++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }
    public void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(E human) {
        for (E child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public E getById(long id) {
        for(E human: humanList) {
            if  (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList) {
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
      public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new humanComporatorByName<>());
    }

    public void sortBySurname() {
        humanList.sort(new humanComporatorBySurname<>());
    }

    public void sortByAge() {
        humanList.sort(new humanComporatorByAge<>());
    }
}
