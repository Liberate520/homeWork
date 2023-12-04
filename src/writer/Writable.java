package writer;

import java.io.Serializable;

public interface Writable {
    void write(Serializable serializable, String file);

    Object read(String file);
}
