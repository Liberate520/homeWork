import java.util.ArrayList;
import java.util.List;

public class Utils {
    private FamilyTree familyTree;

    public Utils(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void print() {
        for (Human human : familyTree.getHumans()) {
            System.out.println(human);
        }
    }

    public List<Human> FindParents(int id) {
        List<Human> res = new ArrayList<>();
        for (Relation relation : familyTree.getRelations()) {
            if (relation.getId1() == id && relation.getNodeID1toID2() == Relation.Node.CHILD) {
                if (familyTree.getHuman(relation.getId2()) != null) {
                    res.add(familyTree.getHuman(relation.getId2()));
                }
            }
        }
        return res;
    }
}
