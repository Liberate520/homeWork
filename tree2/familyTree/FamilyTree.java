package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;
import homeWork.tree2.human.HumanObjectInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class FamilyTree<E extends HumanObjectInterface> implements Serializable, Family<E> {
    private ArrayList<E> families;

    public FamilyTree() {
        families = new ArrayList<>();
    }

    @Override
    public void addPeople(E person) {
        families.add(person);
    }

    public ArrayList<E> familyMembersList(){
        return families;
    }

    public String getFamilies() {
        StringBuilder sb = new StringBuilder();
        for(E person : families){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public E findPersonByName(FamilyTree familyTree, String name) {
        for(E man: families) {
            if(man.getName().equalsIgnoreCase(name)){
                return man;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator(families);
    }
}