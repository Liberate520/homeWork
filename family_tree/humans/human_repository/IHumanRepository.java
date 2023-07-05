package family_tree.humans.human_repository;

import java.util.List;

import family_tree.humans.Human;

public interface IHumanRepository {
    void addHuman(Human human);
    void removeHuman(Human human);
    void updateHuman(Human human);
    List<Human> getAllHumans();
}
