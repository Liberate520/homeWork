package file;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutInput {
    void save(Object ftree) throws FileNotFoundException, IOException;

    Object load() throws ClassNotFoundException, IOException;
}