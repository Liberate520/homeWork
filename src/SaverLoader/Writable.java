package SaverLoader;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable outstream, String path);
    Object load(String path);
    void setFilePath(String path);

}
