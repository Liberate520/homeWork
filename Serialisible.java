import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Serialisible {
    void Serialise(String filename, Object o) throws FileNotFoundException, IOException;
    Object Out(String filename) throws FileNotFoundException, IOException, ClassNotFoundException;
    void SerialiseList(String filename, ArrayList<Object> list) throws FileNotFoundException, IOException;
    ArrayList<Object> OutList(String filename) throws FileNotFoundException, IOException, ClassNotFoundException;
}