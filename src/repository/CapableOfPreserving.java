package repository;
import java.io.Serializable;

/** умеющий сохранять */
public interface CapableOfPreserving {
    /** запись */
    void save(String path, Serializable object);
}
