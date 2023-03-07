package Model;
import java.io.IOException;
import java.util.List;

public interface Saveable {
    void save(List<Human> humalis) throws IOException;

    }
