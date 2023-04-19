import java.io.IOException;
import java.util.List;

public interface ReadWriteData {

    void writeData(List lstObjects) throws IOException;

    List readData() throws IOException, ClassNotFoundException;
}
