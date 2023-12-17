package Family_Tree.model.Writer;

import java.io.Serializable;

public interface Save <E extends Serializable> {
    boolean write(E serializable, String fileName);
    E read(String fileName);
}
