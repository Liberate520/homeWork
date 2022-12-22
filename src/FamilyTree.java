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

    public void addHuman(Human human, Human father, Human mother) {
        if (father != null) {
            human.setFather(father);
            father.getChildren().add(human);
        }
        if (mother != null) {
            human.setMother(mother);
            mother.getChildren().add(human);
        }
        humans.add(human);
    }

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

    public void showAllInConsole() {
        for (Human human : humans) {
            System.out.println(human.toString());
        }
    }
}
