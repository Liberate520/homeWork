import java.io.IOException;

public interface Writeable {
    void save(Object o) throws IOException;
    void read() throws IOException, ClassNotFoundException;
}
