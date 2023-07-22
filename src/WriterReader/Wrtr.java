package homeWork.src.WriterReader;

import java.io.Serializable;

public interface Wrtr {
    String save(Serializable sr, String path);
    Object read(String path);
}
