
import java.io.Serializable;

public interface FileOperations  {
    boolean write(Serializable serializable, String filePath);
    Object read(String filePath);
}
