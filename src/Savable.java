
import java.io.IOException;

public interface Savable {
    void save(Object object, String filename) throws IOException;
    Object load(String filename) throws IOException, ClassNotFoundException;
}
