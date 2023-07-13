package homeWork.FamalyTree.FamalysTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ItemTree<T> extends Serializable{
    void setId(long id);
    long setId();
    String getName();
    String getLastName();
    LocalDate DOB();
    LocalDate DOD();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParents(T human);
    List<T> getChildren();
    List<T> getParents();
    int getAge();
    
}
