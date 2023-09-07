package Tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public interface TreeCommon<T> extends Serializable {
    String getName();
    Integer getAge();
    Integer getId();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    void setId(int id);
    Boolean addChild(T human);
    Boolean addParent(T human);
    List<T> getParents();
    List<T> getChildren();
    T add();

}