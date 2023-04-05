import java.io.IOException;

public interface FileProcessing {
    void save(FamilyTree tree, String fileAddress) throws IOException;
    void read(String fileAddress) throws IOException, ClassNotFoundException;
}
