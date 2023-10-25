package familyTree;

import human.Human;
import human.comparators.CompareByAge;
import human.comparators.CompareByFullName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree;
    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        familyTree.add(human);
    }

    public Human getHumanByFullName(String firstName, String lastName){
        for (Human human: familyTree){
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)){
                return human;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree:\n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    public void sortByFullName(){
        familyTree.sort(new CompareByFullName());
    }

    public void sortByAge(){
        familyTree.sort(new CompareByAge());
    }
}
