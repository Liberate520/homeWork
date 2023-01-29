package Menu;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Select {
    void execute() throws FileNotFoundException, ClassNotFoundException, IOException;

    String discription();
}
