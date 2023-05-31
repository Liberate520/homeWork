
import java.io.IOException;
import java.util.List;

public interface Movable {
    void save(Object object, String filename) throws IOException;
    Object load(String filename) throws IOException, ClassNotFoundException;
}
