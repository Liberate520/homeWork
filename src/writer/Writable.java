package writer;

import java.io.Serializable;

//методы сохранения и загрузки
public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
