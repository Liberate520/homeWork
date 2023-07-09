package family_tree.human_family;

import java.util.List;

import family_tree.humans.Human;

public interface IFamilyTree {
    void addHuman(Human human);

    void removeHuman(Human human);

    void updateHuman(Human human);

    List<Human> getAllHumans();
}