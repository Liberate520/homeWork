package homeWork.src.model.writer;

import java.io.Serializable;
import java.util.List;

public interface Writable {
    boolean save(List<? extends Serializable> serializableList);
    Object read();
}
