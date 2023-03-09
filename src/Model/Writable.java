package Model;

import java.io.Serializable;

public interface Writable<T> {
    String save(Serializable serializable);
    Object read();
}
