import java.io.IOException;
import java.io.Serializable;

/** умеющий сохранять */
public interface CapableOfPreserving {
    /** запись */
    void save(String path, Serializable object) throws IOException;
}
