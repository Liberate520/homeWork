package familytree.serializer;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;

public interface IFamilyTreeLoader {
    FamilyTree<FamilyTreeMemeber> load();
}
