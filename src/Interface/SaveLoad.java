package Interface;

import java.io.Serializable;

public interface SaveLoad {
    void SaveAs(Serializable obj);
    Object LoadAs();
}
