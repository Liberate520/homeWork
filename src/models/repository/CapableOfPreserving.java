package models.repository;
import java.io.Serializable;

/** умеющий сохранять */
public interface CapableOfPreserving {
    /** запись */
    void save(Serializable object);
}
