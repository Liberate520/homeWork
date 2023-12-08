package family.writer;
import family.Tree;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable,String path);
    Object read(String path);
}
