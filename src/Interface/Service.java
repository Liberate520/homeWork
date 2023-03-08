package Interface;

import java.io.Serializable;

public interface Service {

    void save();
    void load();
    String ShowAllPerson();
    abstract void addFater(Integer cur, Integer fat);

}
