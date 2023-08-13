import java.io.IOException;

public interface FamilyTreeSerializable {
    void saveFamilyTree(String fileName) throws IOException;
    void loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
