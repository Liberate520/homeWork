import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void write(Serializable serializable) throws FileNotFoundException;
    Object read() throws FileNotFoundException, IOException;
    
}