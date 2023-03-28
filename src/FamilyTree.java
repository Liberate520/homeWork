import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Member> familyTree = new ArrayList<Member>();

    public FamilyTree(List<Member> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<Member> getFamilyTree() {
        return familyTree;
    }

    public void setFamily(List<Member> familyTree) {
        this.familyTree = familyTree;
    }
    public void addMember(Member newHuman) {
        this.familyTree.add(newHuman);
    }

    public void addAllMember(List<Member> newHuman) {
        this.familyTree.addAll(newHuman);
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }
    
}


