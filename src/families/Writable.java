package families;

import essence.Essence;

import java.io.IOException;
import java.io.Serializable;

public interface Writable<T extends Essence<T>>{
    void save(Serializable obj) throws IOException;
    Family<T> loadFamily() throws IOException, ClassNotFoundException;
}
