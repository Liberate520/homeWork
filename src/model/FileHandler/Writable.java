package FileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface Writable {

    public void save(Object object) throws FileNotFoundException, IOException;

    public Object load() throws FileNotFoundException, IOException;
}
