package familyTreeModel;

import java.io.IOException;
import java.util.Map;

public interface Service {
    String Add(Map<String, String> data) throws ClassNotFoundException, IOException;

    String showList();

    String Search(Map<String, String> data);

    String getChildren(Map<String, String> data);
}
