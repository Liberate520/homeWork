import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable  {
    public void save(Object object) throws IOException;
    public Object read() throws ClassNotFoundException, IOException;
}
