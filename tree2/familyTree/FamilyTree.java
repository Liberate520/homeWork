package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;
import homeWork.tree2.human.HumanObjectInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;


public class FamilyTree implements Serializable, Family{
    private ArrayList<Human> families;


    public FamilyTree() {
        families = new ArrayList<>();
    }

    @Override
    public void addPeople(Human person) {
        families.add(person);
    }

    public ArrayList<Human> familyMembersList(){
        return families;
    }

    public String getFamilies() {
        StringBuilder sb = new StringBuilder();
        for(Human person : families){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Human findPersonByName(FamilyTree familyTree, String name) {
        for(Human man: families) {
            if(man.getName().equalsIgnoreCase(name)){
                return man;
            }
        }
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(families);
    }
}