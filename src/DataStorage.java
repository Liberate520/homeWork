
import java.io.Serializable;

public interface DataStorage extends Serializable {
    void saveData(GenealogicalTree tree, String fileName);
    GenealogicalTree loadData(String fileName);
}






