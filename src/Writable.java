import java.io.FileNotFoundException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable) throws FileNotFoundException;
    Object read();
    
}