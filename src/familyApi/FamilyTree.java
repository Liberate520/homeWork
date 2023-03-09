package familyApi;
import java.util.ArrayList;
import java.util.Iterator;

import familyApi.comparator.HumanComparatorByDate;
import familyApi.comparator.HumanComparatorByName;

public class FamilyTree<T extends User> implements Iterable<T> {
    private ArrayList<T> familyTree;

    public FamilyTree(){ 
        this.familyTree = new ArrayList<T>(); 
    }

    public boolean add(T human){
        if(!familyTree.contains(human)){
            familyTree.add(human);
            return true;
        }
        return false;
    }

    // public boolean addNew(String firstname, String lastname, Human father, Human mother, GregorianCalendar birthdate) {
    //     familyTree.add((T) new Human(firstname, lastname, father, mother, birthdate));
    //     return true;
    // }

    public T getByName(String name){
        for(T human: familyTree){
            if(human.getFirstname().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        String info = "";
        for(T human: familyTree){
            info += human + "\n";
        }
        return info;
    }

    public ArrayList<T> getFamilyTree(){
        return familyTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName<T>());
    }

    public void sortByDate(){
        familyTree.sort(new HumanComparatorByDate<T>());
    }
}
