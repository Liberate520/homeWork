package Project_MyFamilyTree_MVP;

import java.io.Serializable;

public interface Saveable {
    public boolean saveMethod(Serializable serializable, String filesave);
    public Object readMethod(String filesave);
}
