import java.io.IOException;

public interface WriterReader {
    void save(FamilyTree tree, String fileAddress) throws IOException;
    void read(String fileAddress) throws IOException, ClassNotFoundException;
}