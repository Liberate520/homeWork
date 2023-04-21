package families;

import families.Family;

import java.io.IOException;
import java.io.Serializable;

public interface Writable{
    void save(Serializable obj) throws IOException;
    Family loadFamily() throws IOException, ClassNotFoundException;
}
