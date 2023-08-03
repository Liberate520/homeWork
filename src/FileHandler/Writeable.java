package FileHandler;

import java.io.Serializable;

public interface Writeable {
    boolean save(Serializable serializable,String path);
    Object load(String path);
}
