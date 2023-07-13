import common.FTImpersonal;
import iterator_compare.*;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FTImpersonal<E>> implements Serializable {
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

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public E getByName(String fullName){
        for (E human : humanList){
            if(human.getFullName().equals(fullName)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder build = new StringBuilder();
        build.append("In family tree: ");
        build.append(humanList.size());
        build.append(" people: \n");
        for (E human : humanList){
            build.append(human.getInfo());
            build.append("\n");
        }

        return  build.toString();
    }
    @Override
    public String toString (){
        return getInfo();
    }

    public Iterator<E> iterator() {return new HumanIterator(humanList);}
    public void sortByName(){humanList.sort(new HumanComparatorByName());}
    public void sortByBirthDay(){humanList.sort(new HumanComparatorByBirthDay());}

}
