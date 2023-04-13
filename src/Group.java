import java.util.ArrayList;

public interface Group extends Iterable<Human> {
    void addHuman(Human human);
    ArrayList<Human> getHumansList();
    Human getHumanByName(String name);
}
