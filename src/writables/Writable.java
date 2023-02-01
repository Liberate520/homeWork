package writables;
import java.util.List;

public interface Writable<T> {
    void save(List<T> list);
    List<T> read();
}
