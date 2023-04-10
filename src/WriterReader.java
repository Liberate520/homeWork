import java.io.IOException;

public interface WriterReader {
    void save(FamilyTree tree, String fileAddress) throws IOException;
    FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException;
}