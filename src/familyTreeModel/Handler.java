package familyTreeModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Handler {
    void save(Serializable serializable) throws FileNotFoundException, IOException;

    Object download() throws FileNotFoundException, IOException, ClassNotFoundException;
}
