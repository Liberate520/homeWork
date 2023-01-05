import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable {
    public Tree<Human> read() throws FileNotFoundException, IOException, ClassNotFoundException;
}
