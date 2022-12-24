import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, IAddable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList();
    }

    public List<Human> getHumans() {
        return this.humans;
    }

    @Override
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
        return humansList;
    }

    public void showAllInConsole() {
        for (Human human : humans) {
            System.out.println(human.toString());
        }
    }

    public void sortByName() {
        Collections.sort(this.humans);
    }

    public void sortByDate() {
        Collections.sort(this.humans, new HumanComparatorByDate());
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator((this.humans));
    }
}
