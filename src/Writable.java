import java.io.Serializable;

public interface Writable {

    void save(Object object);

    Object read();
}
