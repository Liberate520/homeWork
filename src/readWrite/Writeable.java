package readWrite;

import java.io.Serializable;

public interface Writeable {
    boolean write(Serializable obj);

    Object read();
}
