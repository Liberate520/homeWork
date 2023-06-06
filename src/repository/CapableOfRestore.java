package repository;
import java.io.Serializable;

/** умеющий восстанавливать */
public interface CapableOfRestore {
    /** чтение */
    Serializable read(String path);
}
