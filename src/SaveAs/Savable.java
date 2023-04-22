package SaveAs;
import FamalyTree.FamilyTree;

public interface Savable {
    void save(FamilyTree familyTree, String path);
    FamilyTree upload(String path);
}
