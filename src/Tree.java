import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public interface Tree {
    void addMember(Human human);
    List<Human> getPeopleList();
    List<Human> getChildren(Human human);
    List<Human> getParents(Human human);
    List<Human> getDescendants(Human Human);
    List<Human> getAncestors(Human Human);
    List<Human> getRelatives(Human Human);
    List<Human> searchByName(String name);
    void setMarriage(Human human, Human human2);
    void setChildren(Human human, Human child);
    void save(Writable writable) throws IOException;
    void getInfo();
}
