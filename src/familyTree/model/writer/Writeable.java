package familyTree.model.writer;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Human;

import java.io.IOException;
import java.io.Serializable;

public interface Writeable {
    void save(Serializable serializable, String filePath) throws IOException;
    Serializable read(String filePath);

}
