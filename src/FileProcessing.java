import java.io.IOException;

public interface FileProcessing  {
    void save(FamilyTree familyTree, String fileAddress) throws IOException;
    FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException;
}
