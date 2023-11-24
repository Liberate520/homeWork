package model.familyTree;

import model.human.comparators.CompareByAge;
import model.human.comparators.CompareByFullName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;
    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(E human){
        familyTree.add(human);
    }

    public E getHumanByFullName(String firstName, String lastName){
        for (E human: familyTree){
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)){
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree:\n");
        for (E human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public void sortByFullName(){
        familyTree.sort(new CompareByFullName<>());
    }

    public void sortByAge(){
        familyTree.sort(new CompareByAge<>());
    }
}
