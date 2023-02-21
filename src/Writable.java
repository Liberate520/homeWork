import java.io.IOException;

public interface Writable {

    void save() throws IOException;

    Object read() throws IOException, ClassNotFoundException;
}
