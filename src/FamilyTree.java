import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList();
    }

    public List<Human> getHumans() {
        return this.humans;
    }

    public void setHumans(List<Human> humans) {
        if (this.humans.size() == 0)
            this.humans = humans;
        else
            addAll(humans);
    }

    public void addHuman(Human human) {
        this.humans.add(human);
    }

    public void addAll(List<Human> humans) {
        for (int i = 0; i < humans.size(); i++) {
            this.humans.add(humans.get(i));
        }
    }

    // TODO !!!
    public Human findByName(String name) {
        for (Human human : humans) {
            if (human.getName() == name)
                return human;
        }
        return null;
    }

    public List<Human> findAllByName(String name) {
        List<Human> humansList = new ArrayList();
        for (Human human : humans) {
            if (human.getName() == name)
                humansList.add(human);
        }
        if (humansList != null)
            return humansList;
        else
            return null;
    }
}
