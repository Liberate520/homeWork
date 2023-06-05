package filework;
import java.io.Serializable;

/** умеющий сохранять */
public interface CapableOfPreserving<T extends Serializable> {
    /** запись */
    void save(String path, T object);
}
