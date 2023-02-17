import java.io.IOException;
import java.io.Serializable;

public interface ReadWritable {
    public void write(Serializable obj) throws IOException;
    public Object read() throws IOException, ClassNotFoundException;
}
