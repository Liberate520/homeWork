package file;
import java.io.IOException;

import tree1.FamilyTree;

public interface FileProcess {
    void save(FamilyTree familyTree1, String fileAddress) throws IOException;
    FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException;
}
