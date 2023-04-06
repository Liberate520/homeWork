import java.io.IOException;

public interface FileProcess {
    void save(FamilyTree familyTree1, String fileAddress) throws IOException;
    void read(String fileAddress) throws IOException, ClassNotFoundException;
}
