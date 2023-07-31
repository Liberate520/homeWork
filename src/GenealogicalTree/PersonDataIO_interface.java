package GenealogicalTree;

import java.io.*;
import java.util.*;

public interface PersonDataIO_interface extends Serializable {
    void writeDataToFile(String filename) throws IOException;

    void readDataFromFile(String filename) throws IOException;

}
