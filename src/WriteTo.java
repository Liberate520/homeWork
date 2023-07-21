package Tree.homeWork.src;

import java.io.Serializable;

public interface WriteTo {
    boolean write(Serializable serializable, String filePath);
    Object read(String filePath);
}
