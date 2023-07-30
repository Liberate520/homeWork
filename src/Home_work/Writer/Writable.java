package Home_work.Writer;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String fileDB);
    Object read(String fileDB);
}
