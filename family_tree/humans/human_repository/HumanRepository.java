package family_tree.humans.human_repository;

import java.util.ArrayList;
import java.util.List;

import family_tree.humans.Human;

public class HumanRepository implements IHumanRepository {
    private List<Human> humans;

    public HumanRepository() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public void removeHuman(Human human) {
        humans.remove(human);
    }

    public void updateHuman(Human human) {
        int index = humans.indexOf(human);
        if (index != -1) {
            humans.set(index, human);
        }

    }

    public List<Human> getAllHumans() {
        return humans;
    }
}
