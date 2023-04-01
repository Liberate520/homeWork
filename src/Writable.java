import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;

public interface Writable extends Serializable {
    void save(Writable serializable) throws IOException;

    Object load() throws ClassNotFoundException, InvalidObjectException;
}
