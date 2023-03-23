package familytree.serializer;

import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;

public interface IFamilyTreeSerializer {
    boolean save(Object familyTree);
    FamilyTree<FamilyTreeMemeber> load();
}
