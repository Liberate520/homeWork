package readWrite;

import java.io.IOException;
import java.util.List;

public interface ReadWriteData {

    void writeData(List lstObjects, String fileName) throws IOException;

    List readData(String fileName) throws IOException, ClassNotFoundException;
}
