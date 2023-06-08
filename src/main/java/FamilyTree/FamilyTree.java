package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> family;

    public FamilyTree (){
        family = new ArrayList<>();
    }

    public void addToFamily(Human human) {
        if (!family.contains(human)) {
            this.family.add(human);
        }
    }

    public List<Human> findChildren(String name){
        for (Human human: family){
            if (human.getName().equalsIgnoreCase(name)){
                return human.getChildren();
            }
        }
        return null;
    }

    public void addHuman(Human human) {
        if (!family.contains(human)) {
            this.family.add(human);
        }

    }

    public String getFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human human: family){
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family); //family.iterator();
    }

    public void sortByName(){
        family.sort(new HumanComparatorByName());
    }

    public void sortByBirthdate(){
        family.sort(new HumanComparatorByBirthdate());
    }
}
