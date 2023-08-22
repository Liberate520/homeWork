package home_work.model;

import java.io.Serializable;

public interface Writable {
    void save(Serializable object);
    Object load();
}
