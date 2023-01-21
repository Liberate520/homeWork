package homeWork.src.finalProjectDiary.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable) throws IOException;

    Object read() throws IOException, ClassNotFoundException;
}
