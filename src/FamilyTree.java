import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree){
        this.familyTree = familyTree;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void AddFamilyTree( Human human){
        this.familyTree.add(human);
    }

}
