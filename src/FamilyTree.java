import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> familyTree = new ArrayList<Person>();

    public FamilyTree(List<Person> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<Person> getFamilyTree() {
        return familyTree;
    }

    public void setFamily(List<Person> familyTree) {
        this.familyTree = familyTree;
    }
    public void addMember(Person newHuman) {
        this.familyTree.add(newHuman);
    }

    public void addAllMember(List<Person> newHuman) {
        this.familyTree.addAll(newHuman);
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }
    
}


