package writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import tree.FamilyTree;
public interface Writable {

    FamilyTree load() throws IOException, ClassNotFoundException;
    boolean save(FamilyTree familyTree) throws IOException;
}
