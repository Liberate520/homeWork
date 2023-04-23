import java.io.Serializable;


public interface ReadWrite {
    boolean write (Serializable serializable, String filePath);
    Object read (String filePath);
}
