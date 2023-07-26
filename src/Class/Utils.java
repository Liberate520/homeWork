package Class;

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

    public void fillTree() {
        Human human1 = familyTree.addHuman("Алексей", "Иванов");
        Human human2 = familyTree.addHuman("Алина", "Петрова");
        Human human3 = familyTree.addHuman("Андрей", "Иванов");

        familyTree.addRelation(new Relation(human1.id, human2.id, Relation.Node.MARIAGE));
        familyTree.addRelation(new Relation(human3.id, human1.id, Relation.Node.CHILD));
        familyTree.addRelation(new Relation(human3.id, human2.id, Relation.Node.CHILD));
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
