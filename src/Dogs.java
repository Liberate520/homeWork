import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Dogs<T> extends Serializable {

    int getId();
    void setId(int id);
    void add (T human);
    String getName();
    int getAge();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getChildren();
    T getMarried();
     void setMarried(T human);

    boolean addParent(T parent);
    boolean addChild(T child);
    boolean setWedding (T human1, T human2);
    List<T> getParents();


}
