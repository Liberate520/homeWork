package Model;

import java.io.Serializable;

public interface Writable<T> {
    void save(Serializable serializable);
    Object read();
}
