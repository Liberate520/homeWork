package api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable
{
    String save(Object object) throws IOException;
    Object read() throws IOException, ClassNotFoundException;
}
