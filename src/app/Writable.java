package DZ1.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Writable {
    void save(List<Human> list) throws IOException;

    Object read() throws FileNotFoundException, IOException, ClassNotFoundException;
}
