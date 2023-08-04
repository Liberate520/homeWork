import java.io.IOException;
import java.util.Scanner;

public interface MyFile {
    Scanner file() throws IOException;
    String[] read();
    void write(Person human);
}
