package DZ1.FileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DZ1.Model.Human;

public interface Writable {
    void save(List<Human> list) throws IOException;

    Object read() throws FileNotFoundException, IOException, ClassNotFoundException;
}
