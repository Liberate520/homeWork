package SaveLoad;

import java.io.IOException;
import java.io.Serializable;

public interface Saveable {

    boolean save(Serializable obj) throws IOException;

    Serializable load() throws IOException, ClassNotFoundException;
}
