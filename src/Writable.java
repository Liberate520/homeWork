import java.io.IOException;

public interface Writable  {
    void save(Object object) throws IOException;
    Object read() throws ClassNotFoundException, IOException;


}