import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Processed {
    void save(Serializable serializable) throws FileNotFoundException, IOException;
    Object download() throws FileNotFoundException, IOException, ClassNotFoundException;
    // void write();//Коментарии в FileHandler
    // Object read();

}
