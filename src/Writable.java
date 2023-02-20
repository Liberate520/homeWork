import java.io.Serializable;

public interface Writable {
    public void save(Serializable serializable);
    public Object read();
}
