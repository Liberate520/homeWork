package module.Service;

import java.io.Serializable;

public interface Writable {
    Serializable readFile(String path);

    void saveFile(Serializable serial);
}
