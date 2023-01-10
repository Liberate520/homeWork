import java.util.List;

public interface Writable {
    void save(List<Object> list);
    List<Object> read();
}
