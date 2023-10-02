package Input_output;
import java.io.Serializable;

public interface Writer {
    boolean save (Serializable serializable, String filePath);
    Object read(String filePath);
}
