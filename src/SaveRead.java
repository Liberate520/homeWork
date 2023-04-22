import java.io.IOException;

public interface SaveRead {
    void saveFile(FamilyTree object, String str) throws IOException;
    FamilyTree loadFile(String str) throws IOException, ClassNotFoundException;
}