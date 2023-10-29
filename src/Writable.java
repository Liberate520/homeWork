import java.io.Serializable;

public interface Writable {
    boolean write (Serializable serializable, String filepath);
    Object read (String filepath);
}
