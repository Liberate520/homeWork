import java.io.IOException;

public interface SaveAndLoad {
    void save(String filename) throws IOException;
    void load(String filename) throws IOException, ClassNotFoundException;
}
