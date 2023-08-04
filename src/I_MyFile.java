import java.io.IOException;
import java.util.Scanner;

public interface I_MyFile {
    Scanner file() throws IOException;
    String[] read();
    void write(Person human);
}
