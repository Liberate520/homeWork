package family_tree.model;

import java.io.Serializable;

public interface SaveAs {
    void save(String path, Serializable obj);
}
