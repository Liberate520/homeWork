package family_tree;

import java.util.List;

public interface IHumanRepository {
    void addHuman(Human human);
    void removeHuman(Human human);
    void updateHuman(Human human);
    List<Human> getAllHumans();
}
