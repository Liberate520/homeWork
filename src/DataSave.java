import java.io.IOException;

public interface DataSave {
    void saveData(FamilyTree<Human> familyTree) throws IOException, ClassNotFoundException;
}
