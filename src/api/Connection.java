package api;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Connection {
    public String save(Object object) throws IOException;
    public Object read() throws IOException, ClassNotFoundException;
}
