package homeWorkSem1.Service;
import java.io.IOException;
import java.io.Serializable;



public interface Writeble<T> {
    void save(Serializable serializable) throws IOException;
    T read() throws IOException, ClassNotFoundException;

}
