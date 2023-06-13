package FamilyTree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<Human>, Service {
    private static final long serialVersionUID = 1L;
    private ArrayList<T> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public boolean addMember(T member) {
        if (humanList.contains(member)) {
            return false;
        } else {
            if (member.getFather() != null) {
                T father = (T) member.getFather();
                father.addChild(member);
            }

            if (member.getMother() != null) {
                T mother = (T) member.getMother();
                mother.addChild(member);
            }

            humanList.add(member);
            return true;
        }
    }

    public ArrayList<T> getFamily() {
        return humanList;
    }

    public void sortByChild(ArrayList<T> collection) {
        collection.sort(new ChildComparator<>());
    }

    public void sortByAge(ArrayList<T> collection) {
        collection.sort(new AgeComparator<>());
    }
    public ArrayList<T> getMales(){
        ArrayList<T> males = new ArrayList<T>();
        for (T hum: this.humanList){
            if (hum.getGender().equals("male")){
                males.add(hum);
            }
        }
        return males;
    }
    public ArrayList<T> getFemales(){
        ArrayList<T> females = new ArrayList<T>();
        for (T hum: this.humanList){
            if (hum.getGender().equals("female")){
                females.add(hum);
            }
        }
        return females;
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(humanList);
    }
}
