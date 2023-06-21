package tree.model.handler;

import java.io.IOException;
import java.io.Serializable;

public interface SaveReadable {

    void saveObject(Serializable ob) throws IOException;
    Serializable loadObject() throws IOException, ClassNotFoundException;
}
