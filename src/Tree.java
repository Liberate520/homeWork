import java.util.List;

public interface Tree extends Iterable<Human>{
    void addHuman(Human human);
    List<Human> getHumanList();
}
