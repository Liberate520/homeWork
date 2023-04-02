import java.io.IOException;

public interface FileProcessing  {
    void save(String fileAddress) throws IOException;
    void read(String fileAddress) throws IOException, ClassNotFoundException;
}
