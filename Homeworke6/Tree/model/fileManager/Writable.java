package model.fileManager;

import java.io.Serializable;

public interface Writable {
    void save(Serializable obj);
    Object load();
}