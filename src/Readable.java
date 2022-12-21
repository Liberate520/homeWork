import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable {
    public void read() throws FileNotFoundException, IOException, ClassNotFoundException;
}
