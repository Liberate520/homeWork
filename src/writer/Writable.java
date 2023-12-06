package writer;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String fileName);
    Object load(String fileName);
}
