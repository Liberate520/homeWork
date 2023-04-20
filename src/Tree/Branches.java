package OOPjavaTree.src.Tree;

import OOPjavaTree.src.Data.Operation;
import OOPjavaTree.src.Person.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Branches implements Tree, Serializable {
    private List<Human> familyBranches;

    public Branches(List<Human> familyBranche){
        this.familyBranches = familyBranche;
    }

    public Branches(){
        this(new ArrayList<>());
    }

    public List<Human> getFamilyBranches() {
        return familyBranches;
    }

    public Human getByName(String name){
        for (Human human : familyBranches){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!familyBranches.contains(human)){
            familyBranches.add(human);
                if (human.getFather() != null){
                    human.getFather().addChild(human);
                }
                if (human.getMother() != null){
                    human.getMother().addChild(human);
                }
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (Human human : getFamilyBranches()) {
            sb.append(count++).append(": ");
            sb.append(human.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(getFamilyBranches());
    }
}
