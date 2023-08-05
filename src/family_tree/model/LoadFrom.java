package family_tree.model;

import java.io.Serializable;

public interface LoadFrom {
    Serializable load(String path);
}
