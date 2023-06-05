package filework;
import java.io.Serializable;

/** умеющий восстанавливать */
public interface CapableOfRestore<T extends Serializable> {
    /** чтение */
    T read(String path);
}
