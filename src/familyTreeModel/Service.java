package familyTreeModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface Service {
    String get(HashMap<String, String> selector) throws FileNotFoundException, ClassNotFoundException, IOException;
}
