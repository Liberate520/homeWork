import java.io.IOException;

public interface FileWritableReadable {
    void writeToFile(String filename) throws IOException;
    void readFromFile(String filename) throws IOException;
}
