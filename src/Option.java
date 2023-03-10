import java.io.FileNotFoundException;
import java.io.IOException;

public interface Option {
    String description();
    void execute() throws FileNotFoundException, IOException;
}