package Operations;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Model.Human;

public interface recording {
    void save(List<Human> list) throws IOException;

    Object read() throws FileNotFoundException, IOException, ClassNotFoundException;
}
