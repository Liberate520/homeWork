import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable
{
    void save(Serializable serializable, Object object) throws IOException;
    Object read() throws IOException, ClassNotFoundException;
}
