package FamilyTree.Family;

import FamilyTree.Comparator.HumanComparatorByBirthdate;
import FamilyTree.Comparator.HumanComparatorByName;
import FamilyTree.Family.FamilyItem;
import FamilyTree.Human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyItem> implements Serializable, Iterable<T> {
    private List<T> family;

    public FamilyTree (){
        family = new ArrayList<>();
    }

    public void addToFamily(T human) {
        if (!family.contains(human)) {
            this.family.add(human);
        }
    }

    public List<T> findChildren(String name){
        for (T human: family){
            if (human.getName().equalsIgnoreCase(name)){
                return human.getChildren();
            }
        }
        return null;
    }

    public void addHuman(T human) {
        if (!family.contains(human)) {
            this.family.add(human);
        }

    }

    public String getFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (T human: family){
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() { return new HumanIterator<>(family); }

    public void sortByName(){
        family.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthdate(){
        family.sort(new HumanComparatorByBirthdate<>());
    }
}
