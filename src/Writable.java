import java.util.List;
public interface Writable {
    void save(List<Buffer> list) throws Exception;
    List<Buffer> load() throws Exception;

}