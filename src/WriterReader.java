import java.io.IOException;

public interface WriterReader {
    void save(FamilyTree<Human> tree, String fileAddress) throws IOException;
    FamilyTree<Human> read(String fileAddress) throws IOException, ClassNotFoundException;
}