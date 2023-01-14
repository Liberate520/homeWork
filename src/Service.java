import java.util.List;

public interface Service {
    void addFamilyTree(FamilyTree familyTree);

    Mammal getMember(String name);
    FamilyTree getTree();
    FamilyTree getTree(String index);
    List<String> getTreeNames();
    void sortTree(int sortType);
    String saveTree(int fileType);
    String loadTree(int fileType);
}