import java.util.List;

public interface FamilyGroup<E> {
    E getFather();
    E getMother();
    String getLastName();
    List<E> getChildren();

    void addChild(E human);
}
