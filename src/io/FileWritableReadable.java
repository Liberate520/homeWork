import java.io.IOException;

public interface FileWritableReadable {
    void writeToFile(String filename, GenealogyTree genealogyTree) throws IOException;
    GenealogyTree readFromFile(String filename) throws IOException;
}
