package home_work;

import java.io.Serializable;

public interface Writable {
    void save(Serializable object);
    Object load();
}
