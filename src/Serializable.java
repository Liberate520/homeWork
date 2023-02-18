import java.io.IOException;
import java.util.List;

public interface Serializable {
    void voice(List<Person> humanList) throws IOException, ClassNotFoundException;
}
