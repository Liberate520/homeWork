package Family_Tree.model.Writer;

import java.io.Serializable;

public interface Writable <E extends Serializable>{
    boolean write(E serializable, String filePath);
    E read(String filePath);
}
