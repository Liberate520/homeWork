import java.io.*;

public interface Capabilities extends Serializable {
    void saveData(Serializable serializable) throws IOException;

    Object loadData() throws IOException, ClassNotFoundException;
}
