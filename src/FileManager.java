import java.io.*;

public interface FileManager extends Serializable {
    void saveData(Serializable serializable) throws IOException;

    Object loadData() throws IOException, ClassNotFoundException;
}
