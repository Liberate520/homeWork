package GenealogicalTree;

import java.io.*;
import java.util.*;

public interface PersonDataIO_interface extends Serializable {
    void writeData(List<Person> people, String filename) throws IOException;

    List<Person> readData(String filename) throws IOException;
}
