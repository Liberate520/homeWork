import java.io.IOException;

public interface Writable {
    void writeToFile(FamilyTree tree) throws IOException;
    void readFromFile(FamilyTree tree);
}
