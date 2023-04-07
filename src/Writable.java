import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;

public interface Writable {


    void write(Object obj, String fileName) throws IOException;
    Object read(String fileName) throws IOException, ClassNotFoundException;


//    void save(Serializable serializable) throws IOException;
//
//    Object load() throws ClassNotFoundException, InvalidObjectException;
}
