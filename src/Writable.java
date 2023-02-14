package src;

import java.io.IOException;

public interface Writable {
    boolean saveFile(Object data, String path) throws IOException;
}
