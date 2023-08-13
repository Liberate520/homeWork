package FamiliTree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileHandler {

    Object load() throws FileNotFoundException, IOException;

}