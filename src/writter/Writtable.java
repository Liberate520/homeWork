package writter;

import java.io.Serializable;

public interface Writtable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
