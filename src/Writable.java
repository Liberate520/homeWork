
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void write(String filename, Serializable object) throws IOException;
    Serializable read(String filename);
}