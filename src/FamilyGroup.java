import java.util.List;

public interface FamilyGroup {
    Human getFather();
    Human getMother();
    String getLastName();
    List<Human> getChildren();


}
