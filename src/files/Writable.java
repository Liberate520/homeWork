package files;
import java.io.Serializable;

public interface Writable {

    public  boolean save(Serializable serializable);

    public  Object read(); 
}
